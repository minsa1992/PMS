-- ���̺� ����
  CREATE TABLE pmstest(
    productno NUMBER       NOT NULL,  -- �������� ��ȣ
    title    VARCHAR(300) NOT NULL,  -- ���� ����
    rname    VARCHAR(50)  NOT NULL,  -- �ۼ��� 
    location VARCHAR(50)  NOT NULL,
    rdate    DATE         NOT NULL,  -- �����
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
    productno NUMBER       NOT NULL,  -- �������� ��ȣ
    title    VARCHAR(30) NOT NULL,  -- ���� ����
    location VARCHAR(30)  NOT NULL,
    count NUMBER  NOT NULL,
    ruser    VARCHAR(30)         NOT NULL,  -- �����
    PRIMARY KEY (productno)
);

select * from pmstest3

drop table PMSTEST3


-- ���  
INSERT INTO pmstest3(productno, title, location, count, ruser)
VALUES((SELECT NVL(MAX(productno),0)+1 as productno FROM pmstest3)
       ,'Ȯ�ο��','Ȯ�ο��','15','who');
       
       
INSERT INTO pmstest2(productno, title, location, count, ruser)
VALUES((SELECT NVL(MAX(productno),0)+1 as productno FROM pmstest2)
       ,'��','��','8','who');
       

select * from notice5;






