CREATE TABLE tbl_product(
	product_id NUMBER NOT NULL, --- 제품 코드
	product_name VARCHAR(50) NOT NULL, --- 제품 이름
	stock NUMBER NOT NULL, --- 제품 재고
	price NUMBER NOT NULL, --- 제품 가격
	consumable VARCHAR(5) NOT NULL, ---소모품 여부
	insert_date DATE NOT NULL, --- 최초 등록 일자
	update_date DATE, ---재고 변경 일자
	user_id VARCHAR(80), --- 마지막 사용자 아이디
	brand VARCHAR(100), --- 제품 브랜드 
	poster VARCHAR(255), --- 사진 경로
	PRIMARY KEY (product_id),
	FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
)

alter table tbl_product add product_location varchar(255)

alter table tbl_product add use_date date

select * from tbl_product


INSERT INTO tbl_product(product_id, product_name, stock, price, consumable, insert_date, product_location, user_id)
VALUES((SELECT NVL(MAX(product_id),0)+1 as product_id FROM tbl_product), '동작확인', 5, 6000, 'y', sysdate, '회사', 'test1')

alter table tbl_product add category varchar(50)

alter table tbl_product add usecount NUMBER

select * from ALL_CONSTRAINTS WHERE TABLE_NAME = 'tbl_product'

select insert_date from tbl_product

update tbl_product set use_date='2018-05-10'
where product_id = 7
