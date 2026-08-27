DROP DATABASE IF EXISTS mydb0827;
CREATE DATABASE mydb0827;
USE mydb0827;
CREATE TABLE waiting( 
    no int AUTO_INCREMENT , 
    phone VARCHAR(20) ,
    count INT NOT NULL ,
    constraint PRIMARY KEY( no ) 
);
insert into waiting( phone, count )
values
( "010-1212-1212" , 4 ),
( "010-3434-3434" , 2 ),
( "010-5656-5656" , 3 ); -- 샘플 데이터 3개 