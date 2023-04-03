--��ǰ����

drop table product;


create table product(
    pid  number(10),
    pname       varchar(30) NOT NULL,
    quantity    number(10) NOT NULL,
    price       number(10) NOT NULL
);
--�⺻Ű
alter table product add constraint product_pid_pk primary key(pid);

--����������
drop sequence product_pid_seq;
create sequence product_pid_seq;

--����--
insert into product(pid,pname,quantity,price)
     values(product_pid_seq.nextval, '��ǻ��', 5, 1000000);

insert into product(pid,pname,quantity,price)
     values(product_pid_seq.nextval, '�����', 5, 500000);

insert into product(pid,pname,quantity,price)
     values(product_pid_seq.nextval, '������', 1, 300000);

--��ü��ȸ-
select pid,pname,quantity,price from product;

commit;