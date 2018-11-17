-- 권한
insert into role (id, name) values (null, 'root');
insert into role (id, name) values (null, 'vip');
insert into role (id, name) values (null, 'member');

-- 회원
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point, role_id) values(null, 'root@fc.com', 'root', 'root', '1234', '010-1111-1111', '서울', '111-111', 0, 0, '남자', '1/1', 9999, 1);
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point, role_id) values(null, 'urstory@fc.com', '김성박', 'urstory', '1234', '010-2222-2222', '서울', '222-222', 0, 0, '남자', '2/2', 1000, 2);
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point, role_id) values(null, 'crazy@fc.com', '김준형', 'crazy', '1234', '010-3333-3333', '서울', '333-333', 0, 0, '남자', '3/3', 0, 3);
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point, role_id) values(null, 'jhj@fc.com', '장현준', 'jhj', '1234', '010-4444-4444', '경상도', '444-444', 0, 0, '남자', '4/4', 0, 3);
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point, role_id) values(null, 'kkm@fc.com', '김규민', 'kkm', '1234', '010-5555-5555', '인천', '555-555', 0, 0, '남자', '5/5', 0, 3);

-- 카테고리
insert into category(id, name) values(null, '아우터');
insert into category(id, name) values(null, '상의');
insert into category(id, name) values(null, '하의');
insert into category(id, name) values(null, '셔츠');

-- 상품
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '111', 'Luxury 세미오버 최고급울코트[WOOL]', 5890, 58900, 10, '최고의 멋내기 아이템, 아우터! 때로는 멋지게 때로는 시크하게 아우터 하나로 간편 스타일링 OK!', 0, 580, 1);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '222', '[오리솜털90%]극강의가벼움 롱패딩OT', 15900, 159000, 10, '오리가슴털 함량이 많은 제품! 제품 받으셨을땐 눌린채로 포장되어 빵빵함이 덜 할 수 있어요. 옷걸이에 걸어서 팡팡 두드려 주시면 오리 가슴털이 금방 살아나서 빵빵한 본연의 모습을 보실 수 있습니다.', 0, 1590, 1);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '333', '사르르 콤비양털오버 집업자켓OT', 3360, 33600, 10, '겉&속 ALL 양털!! 보들보들한 촉감에 놀라지 마세요!', 0, 330, 1);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '444', '리버서블 양털누빔 앙면베스트OT', 4950, 49500, 10, '양털조끼로 코디해서 입을 수 있고 뒤집어서 누빔조끼로도 입을 수 있는 상품! 양면을 다 이용하여 스타일링 가능하여 코디 활용도가 높은 상품', 0, 490, 1);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '555', '세이브 겉기모 체크오버 롱셔츠', 3900, 39000, 10, '보온성 좋은 겉기모 원단으로 기모의 보온성은 살리고, 까끌거리는 착용감은 보완한 상', 0, 390, 2);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '666', '코디하기좋은 오버V넥니트MU', 1490, 14900, 10, '톤다운 컬러 구성으로 소장가치 높은 브이넥니트!', 0, 140, 2);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '777', '컬러네임자수 포켓 오버니트 맨투맨', 2160, 21600, 10, '귀여우면서 유니크한 느낌을 주는 기모 니트맨투', 0, 210, 2);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '888', '노멀클래식 오버카라니트MU', 2480, 24800, 10, 'F/W 시즌에 맞는 톤다운된 트렌디한 컬러 구성, 컬러별로 다양한 스타일을 연출할 수 있어 코디 활용도가 높은 제품!', 0, 240, 2);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '999', '10부 힙한 양털 조거바지', 1920, 19200, 10, '부드럽고 도톰한 두께감으로 보온성이 좋은 상품! 신축성이 좋아 편안하게 착용 가능', 0, 190, 3);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '1010', '9부 도톰 기모 슬랙스', 2780, 27800, 10, '겉감 기모처리로 보온성은 물론 보기에도 따뜻해 보이는 소재의 F/W 데일리 슬랙스', 0, 270, 3);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '1111', '10부 컷팅 반스키니 청바지', 3640, 36400, 10, '03 워싱 공정으로 일반워싱보다 CO2 배출이 50% 감축했으며, 청바지 워싱공정 중에 나오는 화공약품을 99% 살균소독하는 상품!', 0, 360, 3);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '1212', '선택코디 후리스 셔츠자켓MU', 1990, 19900, 10, '일반 셔츠 보단 훨씬 두껍고, 정장 자켓 보다는 얇음, 밑단이 라운딩 되어, 착용 시 라인이 부드럽다', 0, 190, 4);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '1313', '겉기모 루피 오버체크셔츠', 1690, 16900, 10, '보온성 좋은 겉기모 원단으로 기모의 보온성은 살리고, 까끌거리는 착용감은 보완한 상품', 0, 160, 4);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '1414', '웜톤 11컬러 오버피치셔츠MU', 1490, 14900, 10, '11가지의 따뜻한 웜톤컬러에 부드러운 피치셔츠 입니다.', 0, 140, 4);
insert into item(id, code, name, price, money, total_stock, explanation, max_order_num, point, category_id) values(null, '1515', '컬러대장 코듀오버 긴팔셔츠MU', 2700, 27000, 10, '도톰한 두께감의 코듀로이 셔츠로, 쌀쌀한 가을도 추운 겨울도 OK!', 0, 270, 4);

-- 상품 이미지

-- 이벤트

-- 결제

-- 쿠폰

-- 배송

-- 배송업체

-- 주문

-- 주문 상품

-- 클레임