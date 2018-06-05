CREATE TABLE tbl_request(
	request_id NUMBER NOT NULL, --- ��û ���̵� ����
	product_name VARCHAR(50) NOT NULL, --- ��û ��ǰ �̸� 
	product_num NUMBER NOT NULL, --- ����
	request_reason VARCHAR(255), --- ���� ��û ����
	product_url VARCHAR(255), --- ���� ���� �ּ�
	insert_date DATE NOT NULL, --- ��� ����
	user_id VARCHAR(30) NOT NULL, --- ���� ��û��
	PRIMARY KEY (request_id)
)

alter table tbl_request add product_result varchar(10)

INSERT INTO tbl_request(request_id, product_name, product_num, request_reason, product_url, insert_date, user_id)
VALUES((SELECT NVL(MAX(request_id),0)+1 as request_id FROM tbl_request), '�׽�Ʈ��', 10, '�׽�Ʈ��', 'www.naver.com', sysdate, '�׽�Ʈ��')

INSERT INTO tbl_request(request_id, product_name, product_num, request_reason, product_url, insert_date, user_id)
VALUES((SELECT NVL(MAX(request_id),0)+1 as request_id FROM tbl_request), '��������', 5, '�ؾ���', 'www.goole.com', sysdate, '����')

INSERT INTO tbl_request(request_id, product_name, product_num, request_reason, product_url, insert_date, user_id)
VALUES((SELECT NVL(MAX(request_id),0)+1 as request_id FROM tbl_request), '���ɹ���', 45, '��������', 'www.naver.com', sysdate, '����')

SELECT request_id, product_name, product_num, request_reason, product_url, insert_date, user_id
FROM tbl_request

SELECT * FROM tbl_request

update tbl_request set product_result='q' where product_name='����'

delete from tbl_request where user_id='usertest'
