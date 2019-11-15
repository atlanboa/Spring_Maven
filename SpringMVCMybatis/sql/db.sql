drop table board;

create table board (
	no  int(20) primary key,
	id  varchar(20) not null,
	title  varchar(200) not null,
	contents  varchar(20) not null
);

insert  into board values(1,'diana','월말평가 실습','잘 실행 되나요?');
commit;