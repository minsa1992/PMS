-- 테이블 생성
  CREATE TABLE pmstest(
    productno NUMBER       NOT NULL,  -- 공지사항 번호
    title    VARCHAR(300) NOT NULL,  -- 공지 내용
    rname    VARCHAR(50)  NOT NULL,  -- 작성자 
    location VARCHAR(50)  NOT NULL,
    rdate    DATE         NOT NULL,  -- 등록일
    PRIMARY KEY (productno)
);

CREATE TABLE admintest(
	ID VARCHAR(30) NOT NULL,
	PASSWORD VARCHAR(30) NOT NULL,
	PRIMARY KEY (ID)
)

select * from pmstest3

INSERT INTO admintest(ID, PASSWORD)
VALUES('test', 'test')

select 
  
CREATE TABLE pmstest3(
    productno NUMBER       NOT NULL,  -- 공지사항 번호
    title    VARCHAR(30) NOT NULL,  -- 공지 내용
    location VARCHAR(30)  NOT NULL,
    count NUMBER  NOT NULL,
    ruser    VARCHAR(30)         NOT NULL,  -- 등록일
    PRIMARY KEY (productno)
);

select * from pmstest3

drop table PMSTEST3


-- 등록  
INSERT INTO pmstest3(productno, title, location, count, ruser)
VALUES((SELECT NVL(MAX(productno),0)+1 as productno FROM pmstest3)
       ,'확인용들','확인용들','15','who');
       
       
INSERT INTO pmstest2(productno, title, location, count, ruser)
VALUES((SELECT NVL(MAX(productno),0)+1 as productno FROM pmstest2)
       ,'시','시','8','who');
       

select * from notice5;






