CREATE TABLE tbl_user(
	user_no NUMBER NOT NULL,
	user_id VARCHAR(80) NOT NULL, --- 사용자 아이디
	password VARCHAR(80) NOT NULL, --- 사용자 패스워드
	user_name VARCHAR(80) NOT NULL, --- 사용자 이름
	email VARCHAR(100) NOT NULL, --- 사용자 이메일
	division_code NUMBER NOT NULL, ---사업부 코드
	position_name VARCHAR(50) NOT NULL, ---직급명
	insert_date DATE NOT NULL, ---계정 생성 일자
	update_date DATE, ---계정 수정 일자
	user_grade VARCHAR(20) DEFAULT 'A' NOT NULL, ---계정사용가능 여부
	login_date DATE, ---계정 로그인 날짜
	PRIMARY KEY (user_id)
)

drop table tbl_user

INSERT INTO TBL_USER(user_no, user_id, password, user_name, email, division_code, position_name, insert_date)
VALUES((SELECT NVL(MAX(user_no),0)+1 as user_no FROM tbl_user), 'usertest', 'usertest', '송민상', 'minsa@haniln.com', 2, '인턴', sysdate)

select * from tbl_user

delete from tbl_user where user_no = 4
