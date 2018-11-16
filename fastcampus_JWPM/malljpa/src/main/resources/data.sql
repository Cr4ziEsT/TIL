-- 권한
insert into role (id, name) values (null, 'root');
insert into role (id, name) values (null, 'vip');
insert into role (id, name) values (null, 'member');

-- 회원
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point, role_id) values(null, 'kim@fc.com', '김', 'crazy', '1234', '010-1111-1111', '서울', '111-111', 0, 0, '남자', '1/1', 99999, 1);
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point, role_id) values(null, 'jun@fc.com', '준', 'craziest', '1234', '010-2222-2222', '인천', '222-222', 0, 0, '남자', '2/2', 0, 2);
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point, role_id) values(null, 'hyung@fc.com', '형', 'cr4zy', '1234', '010-3333-3333', '전라도', '333-333', 0, 0, '남자', '3/3', 0, 3);

-- 카테고리
insert into category(id, name) values(null, 'category 1');
insert into category(id, name) values(null, 'category 2');
insert into category(id, name) values(null, 'category 3');

-- 상품
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '111', '상품1', 100, 1000, 10, '이것은 상품1 이다.', 0, 1, 1);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '222', '상품2', 200, 2000, 20, '이것은 상품2 이다.', 0, 2, 2);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '333', '상품3', 300, 3000, 30, '이것은 상품3 이다.', 0, 3, 3);

-- 상품 이미지
insert into item_image(id, file_name, file_size, item_id) values (null, '상품1 이미지', 111, 1);
insert into item_image(id, file_name, file_size, item_id) values (null, '상품2 이미지', 222, 2);
insert into item_image(id, file_name, file_size, item_id) values (null, '상품3 이미지', 333, 3);

-- 이벤트

-- 결제

-- 쿠폰

-- 배송

-- 배송업체

-- 주문

-- 주문 상품

-- 클레임