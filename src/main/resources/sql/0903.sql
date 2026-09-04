-- day05 / TestEntity sample , SQL 카멜표기법 대신에 _(언더바)
INSERT INTO test( name , ddescc , price , create_date , update_date )
    value( '코카콜라' , '맛있는 탄산음료1' , 1000 , now() , now() ),
    ( '코카콜라2' , '맛있는 탄산음료2' , 1500 , now() , now() ),
    ( '코카콜라3' , '맛있는 탄산음료3' , 700 , now() , now() );
