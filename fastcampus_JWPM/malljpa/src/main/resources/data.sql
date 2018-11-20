-- 권한
insert into role (id, name) values (null, 'ADMIN');
insert into role (id, name) values (null, 'VIP');
insert into role (id, name) values (null, 'USER');

-- 회원
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point) values(null, 'root@fc.com', 'root', 'root', '{bcrypt}$2a$10$.Jgr.Ul6C4usgmuJJ4dmNuwUz16d6T58UiZiU10W.doLhXVqJDLHW', '010-1111-1111', '서울', '111-111', 0, 0, '남자', '1/1', 9999);
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point) values(null, 'urstory@fc.com', '김성박', 'urstory', '{bcrypt}$2a$10$.Jgr.Ul6C4usgmuJJ4dmNuwUz16d6T58UiZiU10W.doLhXVqJDLHW', '010-2222-2222', '서울', '222-222', 0, 0, '남자', '2/2', 1000);
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point) values(null, 'crazy@fc.com', '김준형', 'crazy', '{bcrypt}$2a$10$.Jgr.Ul6C4usgmuJJ4dmNuwUz16d6T58UiZiU10W.doLhXVqJDLHW', '010-3333-3333', '서울', '333-333', 0, 0, '남자', '3/3', 0);
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point) values(null, 'jhj@fc.com', '장현준', 'jhj', '{bcrypt}$2a$10$.Jgr.Ul6C4usgmuJJ4dmNuwUz16d6T58UiZiU10W.doLhXVqJDLHW', '010-4444-4444', '경상도', '444-444', 0, 0, '남자', '4/4', 0);
insert into member(id, email, name, nickname, password, phone_num, home_address, zip_code, height, weight, gender, birth_day, point) values(null, 'kkm@fc.com', '김규민', 'kkm', '{bcrypt}$2a$10$.Jgr.Ul6C4usgmuJJ4dmNuwUz16d6T58UiZiU10W.doLhXVqJDLHW', '010-5555-5555', '인천', '555-555', 0, 0, '남자', '5/5', 0);

-- 회원_권한
insert into member_role(member_id, role_id) values (1, 1);
insert into member_role(member_id, role_id) values (1, 2);
insert into member_role(member_id, role_id) values (1, 3);
insert into member_role(member_id, role_id) values (2, 2);
insert into member_role(member_id, role_id) values (2, 3);
insert into member_role(member_id, role_id) values (3, 3);
insert into member_role(member_id, role_id) values (4, 3);
insert into member_role(member_id, role_id) values (5, 3);

-- 카테고리
insert into category(id, name) values(null, 'Java');
insert into category(id, name) values(null, 'JSP');
insert into category(id, name) values(null, 'Spring');

-- 상품
insert into item(id, code, name, price, money, total_stock, explanation, main_image_path, max_order_num, point, category_id) values(null, '111', 'Java의 정석', 2700, 27000, 10, '최근 7년동안 자바 분야의 베스트 셀러 1위를 지켜온 ''자바의 정석''의 최신판. 저자가 카페에서 12년간 직접 독자들에게 답변을 해오면서 초보자가 어려워하는 부분을 잘 파악하고 쓴 책. 뿐만 아니라 기존의 경력자들을 위해 자바의 최신기능(람다와 스트림)을 자세하면서도 깊이있게 설명하고 있다. 저자가 2002년부터 꾸준히 집필해온 책으로 깊이와 세밀함 그리고 저자의 정성과 노력이 돋보이는 책이다. 12년간 저자가 카페에서 손수 답변해줬다는 사실은 이 책에 대한 신뢰를 갖게 한다.', '/images/Java의 정석.jpg',  0, 270, 1);
insert into item(id, code, name, price, money, total_stock, explanation, main_image_path, max_order_num, point, category_id) values(null, '222', '자바의 신', 2700, 27000, 10, '성능 전문가로 널리 알려진 저자가 십수 년의 자바 개발 경험을 바탕으로 현장에서 꼭 필요한 기초지식을 정리한 책이다. 현장 중심으로 자바의 기본서를 다시 정의한 책이다. 독자가 생각하며 학습할 수 있도록 구성하였고 연습문제에 심혈을 기울였다. 23명의 베타리더 및 감수자가 먼저 리뷰하고 의견을 반영하였다. 4년 만의 개정판에서는 Java 8 버전 내용과 JavaFX 내용을 추가하였고, 1판 독자의 의견을 수렴하여 기본서에 더 충실할 수 있도록 내용을 수정 보완하였다.', '/images/자바의 신.jpg', 0, 270, 1);
insert into item(id, code, name, price, money, total_stock, explanation, main_image_path, max_order_num, point, category_id) values(null, '333', '이것이 자바다', 2700, 27000, 10, '성능 전문가로 널리 알려진 저자가 십수 년의 자바 개발 경험을 바탕으로 현장에서 꼭 필요한 기초지식을 정리한 책이다. 현장 중심으로 자바의 기본서를 다시 정의한 책이다. 독자가 생각하며 학습할 수 있도록 구성하였고 연습문제에 심혈을 기울였다. 23명의 베타리더 및 감수자가 먼저 리뷰하고 의견을 반영하였다. 4년 만의 개정판에서는 Java 8 버전 내용과 JavaFX 내용을 추가하였고, 1판 독자의 의견을 수렴하여 기본서에 더 충실할 수 있도록 내용을 수정 보완하였다.', '/images/이것이 자바다.jpg', 0, 270, 1);
insert into item(id, code, name, price, money, total_stock, explanation, main_image_path, max_order_num, point, category_id) values(null, '444', '쉽게 배우는 JSP 웹 프로그래밍', 2700, 27000, 10, 'JSP의 이론적 개념 → 기본 실습 → 응용 실습 순의 단계별 학습이 가능하다. 응용 실습이 합쳐져 최종적으로 쇼핑몰 하나를 완성하는 구성이라 배운 내용이 어디에 어떻게 적용되는지 알 수 있다. ', '/images/쉽게배우는JSP웹프로그래밍.jpg', 0, 270, 2);
insert into item(id, code, name, price, money, total_stock, explanation, main_image_path, max_order_num, point, category_id) values(null, '555', '뇌를 자극하는 JSP&Servlet', 2700, 27000, 10, '흔히 마주치는 수많은 웹 페이지들은 어떻게 만들고 운영되고 있는 것일까? 이 책은 이 질문에 대한 해답과 함께 JSP, Servlet을 활용해 다양하고 실용적인 웹 페이지를 구성하는 방법을 알려준다. 기본적인 JSP와 Servlet의 기초 개념부터 쿠키와 세션, 각종 액션 등의 다양한 내용은 물론 시스템 설계와 좋은 UI 구성까지 모두 담아냈다. 또한 최신 버전과 서비스 경향을 반영한 생생한 예제를 하나하나 따라하며 실습해 볼 수 있도록 구성했다. 때문에 마지막 장까지 마스터하면 실무에서도 더욱 자신감 있게 코딩할 수 있다. 이제 이 책과 함께 즐거운 웹 프로그래밍 세상으로 여행을 떠나보자.', '/images/뇌자극JSP.jpg', 0, 270, 2);
insert into item(id, code, name, price, money, total_stock, explanation, main_image_path, max_order_num, point, category_id) values(null, '666', '웹 개발자를 위한 Spring 4.0', 2880, 28800, 10, '웹 개발자를 위한 Spring 4.0 프로그래밍 도서로 스프링 4의 새로운 특징 포함하였다. 스프링 DI, AOP, 스프링 MVC, 스프링 웹소켓, JDB, 하이버네이트, JPA, MyBatis 연동, 스프링 데이터 JPA, 일반적인 웹 어플리케이션 구조 소개, 스프링 시큐리티를 이용한 웹 보안 구현, 메일 발송, 스케쥴링, RestTemplates, 스프링을 이용한 JUnit 테스트을 포함하고 있다.', '/images/spring4.0.jpg', 0, 280, 3);
insert into item(id, code, name, price, money, total_stock, explanation, main_image_path, max_order_num, point, category_id) values(null, '777', '토비의 스프링', 6750, 67500, 10, '『토비의 스프링 3.1』은 스프링을 처음 접하거나 스프링을 경험했지만 스프링이 어렵게 느껴지는 개발자부터 스프링을 활용한 아키텍처를 설계하고 프레임워크를 개발하려고 하는 아키텍트에 이르기까지 모두 참고할 수 있는 스프링 완벽 바이블이다.', '/images/토비의 스프링.jpg', 0, 670, 3);

-- 상품 이미지
insert into item_image(id, file_name, file_path, file_size, item_id) values(null, 'java의 정석', '/images/java의 정석.jpg', '60 x 60 mm', 1);
insert into item_image(id, file_name, file_path, file_size, item_id) values(null, '자바의 신', '/images/자바의 신.jpg', '60 x 60 mm', 2);
insert into item_image(id, file_name, file_path, file_size, item_id) values(null, '이것이 자바다', '/images/이것이 자바다.jpg', '60 x 60 mm', 3);
insert into item_image(id, file_name, file_path, file_size, item_id) values(null, '쉽게 배우는 JSP 웹 프로그래밍', '/images/쉽게배우는JSP웹프로그래밍.jpg', '60 x 60 mm', 4);
insert into item_image(id, file_name, file_path, file_size, item_id) values(null, '뇌를 자극하는 JSP&Servlet', '/images/뇌자극JSP.jpg', '60 x 60 mm', 5);
insert into item_image(id, file_name, file_path, file_size, item_id) values(null, '웹 개발자를 위한 Spring 4.0', '/images/spring4.0.jsp', '60 x 60 mm', 6);
insert into item_image(id, file_name, file_path, file_size, item_id) values(null, '토비의 스프링', '/images/토비의 스프링.jpg', '60 x 60 mm', 7);

-- 주문
insert into ordering(id, code, count, discount_money, money, order_date, point, member_id, payment_id, shipping_id) values (null, '1101001', 2, 0, 54000, now(), 0, 3, null, null);
insert into ordering(id, code, count, discount_money, money, order_date, point, member_id, payment_id, shipping_id) values (null, '2202002', 1, 0, 67500, now(), 0, 4, null, null);

-- 주문 상품
insert into ordering_item(id, count, money, claim_id, item_id, ordering_id) values (null, 1, 27000, null, 1, 1);
insert into ordering_item(id, count, money, claim_id, item_id, ordering_id) values (null, 1, 27000, null, 2, 1);
insert into ordering_item(id, count, money, claim_id, item_id, ordering_id) values (null, 1, 27000, null, 7, 2);

----------
-- 이벤트
-- 결제
-- 쿠폰
-- 배송
-- 배송업체
-- 클레임