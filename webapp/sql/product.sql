CREATE TABLE tbl_product(
	product_id NUMBER NOT NULL, --- ��ǰ �ڵ�
	product_name VARCHAR(50) NOT NULL, --- ��ǰ �̸�
	stock NUMBER NOT NULL, --- ��ǰ ���
	price NUMBER NOT NULL, --- ��ǰ ����
	consumable VARCHAR(5) NOT NULL, ---�Ҹ�ǰ ����
	insert_date DATE NOT NULL, --- ���� ��� ����
	update_date DATE, ---��� ���� ����
	user_id VARCHAR(80), --- ������ ����� ���̵�
	brand VARCHAR(100), --- ��ǰ �귣�� 
	poster VARCHAR(255), --- ���� ���
	PRIMARY KEY (product_id),
	FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
)

alter table tbl_product add product_location varchar(255)

alter table tbl_product add use_date date

select * from tbl_product


INSERT INTO tbl_product(product_id, product_name, stock, price, consumable, insert_date, product_location, user_id)
VALUES((SELECT NVL(MAX(product_id),0)+1 as product_id FROM tbl_product), '����Ȯ��', 5, 6000, 'y', sysdate, 'ȸ��', 'test1')

alter table tbl_product add category varchar(50)

alter table tbl_product add usecount NUMBER

select * from ALL_CONSTRAINTS WHERE TABLE_NAME = 'tbl_product'

select insert_date from tbl_product

update tbl_product set use_date='2018-05-10'
where product_id = 7
