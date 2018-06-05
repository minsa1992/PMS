CREATE TABLE tbl_request(
	request_id NUMBER NOT NULL, --- 요청 아이디 생성
	product_name VARCHAR(50) NOT NULL, --- 요청 물품 이름 
	product_num NUMBER NOT NULL, --- 수량
	request_reason VARCHAR(255), --- 구매 요청 사유
	product_url VARCHAR(255), --- 구매 가능 주소
	insert_date DATE NOT NULL, --- 등록 일자
	user_id VARCHAR(30) NOT NULL, --- 구매 요청자
	PRIMARY KEY (request_id)
)

alter table tbl_request add product_result varchar(10)

INSERT INTO tbl_request(request_id, product_name, product_num, request_reason, product_url, insert_date, user_id)
VALUES((SELECT NVL(MAX(request_id),0)+1 as request_id FROM tbl_request), '테스트용', 10, '테스트용', 'www.naver.com', sysdate, '테스트용')

INSERT INTO tbl_request(request_id, product_name, product_num, request_reason, product_url, insert_date, user_id)
VALUES((SELECT NVL(MAX(request_id),0)+1 as request_id FROM tbl_request), '오늘할일', 5, '해야해', 'www.goole.com', sysdate, '내가')

INSERT INTO tbl_request(request_id, product_name, product_num, request_reason, product_url, insert_date, user_id)
VALUES((SELECT NVL(MAX(request_id),0)+1 as request_id FROM tbl_request), '점심뭐먹', 45, '뭐먹을까', 'www.naver.com', sysdate, '누가')

SELECT request_id, product_name, product_num, request_reason, product_url, insert_date, user_id
FROM tbl_request

SELECT * FROM tbl_request

update tbl_request set product_result='q' where product_name='휴지'

delete from tbl_request where user_id='usertest'
