package com.ohgiraffers.userservice.service;

import com.ohgiraffers.userservice.aggregate.UserEntity;
import com.ohgiraffers.userservice.dto.UserDTO;
import com.ohgiraffers.userservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    @Override
    public void registUser(UserDTO userDTO) {

        /* 설명. userId가 비어있는 상태인데 UUID를 활용하여 서버측에서 회원의 고유한 아이디를 생성한다. */
        userDTO.setUserId(UUID.randomUUID().toString());

        /* 설명. 필드값이 정확히 일치할 때만 매칭하기 위해 STRICT 모드 상태로 modelMapper를 설정한다.(STANDARD -> STRICT) */
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

        /* 설명. spring security 모듈 추가 후 진행하므로 security 설정도 추가한다. */
//        userEntity.setEncryptedPwd("암호화 된 비밀번호");
        userEntity.setEncryptedPwd(bCryptPasswordEncoder.encode(userDTO.getPwd()));

        userRepository.save(userEntity);
    }

    /* 설명. 토큰의 재료인 userId(사용자 고유 번호) 조회를 위해 만들어진 메소드 */
    @Override
    public UserDTO getUserdetailsByEmail(String email) {

        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null)
            throw new UsernameNotFoundException(email + " 아이디의 유저는 존재하지 않음");

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);

        return userDTO;
    }

    @Override
    public UserDTO getUserById(String id) {

        UserEntity userEntity = userRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("조회된 회원 없음");
                });

        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);

        return userDTO;
    }

    /* 설명. UserDetailsService 인터페이스 상속 이후 DB에서 로그인 사용자 정보 조회 후 UserDetails 타입으로 반환하는 기능 구현 */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null)
            throw new UsernameNotFoundException(email + " 아이디의 유저는 존재하지 않습니다.");

        return new User(userEntity.getEmail(), userEntity.getEncryptedPwd(),
                true, true, true, true,
                new ArrayList<>());
    }
}
