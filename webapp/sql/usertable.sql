CREATE TABLE tbl_user(
	user_no NUMBER NOT NULL,
	user_id VARCHAR(80) NOT NULL, --- ����� ���̵�
	password VARCHAR(80) NOT NULL, --- ����� �н�����
	user_name VARCHAR(80) NOT NULL, --- ����� �̸�
	email VARCHAR(100) NOT NULL, --- ����� �̸���
	division_code NUMBER NOT NULL, ---����� �ڵ�
	position_name VARCHAR(50) NOT NULL, ---���޸�
	insert_date DATE NOT NULL, ---���� ���� ����
	update_date DATE, ---���� ���� ����
	user_grade VARCHAR(20) DEFAULT 'A' NOT NULL, ---������밡�� ����
	login_date DATE, ---���� �α��� ��¥
	PRIMARY KEY (user_id)
)

drop table tbl_user

INSERT INTO TBL_USER(user_no, user_id, password, user_name, email, division_code, position_name, insert_date)
VALUES((SELECT NVL(MAX(user_no),0)+1 as user_no FROM tbl_user), 'usertest', 'usertest', '�۹λ�', 'minsa@haniln.com', 2, '����', sysdate)

select * from tbl_user

delete from tbl_user where user_no = 4
