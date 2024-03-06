CREATE TABLE IF NOT EXISTS tbl_order2
(
    order_code    INT AUTO_INCREMENT COMMENT '주문코드',
    user_id       VARCHAR(255) NOT NULL COMMENT '주문고객',
    order_date    VARCHAR(8) NOT NULL COMMENT '주문일자',
    order_time    VARCHAR(8) NOT NULL COMMENT '주문시간',
    total_order_price    INT NOT NULL COMMENT '총주문금액',
    CONSTRAINT pk_order_code2 PRIMARY KEY (order_code)
    ) ENGINE=INNODB COMMENT '주문';

CREATE TABLE IF NOT EXISTS tbl_order_menu2
(
    order_code INT NOT NULL COMMENT '주문코드',
    menu_code    INT NOT NULL COMMENT '메뉴코드',
    order_amount    INT NOT NULL COMMENT '주문수량',
    CONSTRAINT pk_comp_order_menu_code2 PRIMARY KEY (order_code, menu_code),
    CONSTRAINT fk_order_menu_order_code2 FOREIGN KEY (order_code) REFERENCES tbl_order2 (order_code),
    CONSTRAINT fk_order_menu_menu_code2 FOREIGN KEY (menu_code) REFERENCES tbl_menu (menu_code)
    ) ENGINE=INNODB COMMENT '주문별메뉴';

INSERT INTO TBL_ORDER2 VALUES (1, 1, '20240301', '12:23:14', 16000);
INSERT INTO TBL_ORDER2 VALUES (2, 1, '20240301', '12:23:14', 14000);
INSERT INTO TBL_ORDER_MENU2 VALUES (1, 2, 2);
INSERT INTO TBL_ORDER_MENU2 VALUES (1, 3, 1);
INSERT INTO TBL_ORDER_MENU2 VALUES (2, 4, 2);

COMMIT;