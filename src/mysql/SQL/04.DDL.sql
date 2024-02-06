###################################################
#
# 데이터 정의 언어(DDL:Data Definition Language)
#
###################################################

# 주소록 테이블 생성
CREATE TABLE addrBook
(
   aid int NOT NULL AUTO_INCREMENT,
   name varchar(16) NOT NULL,
   tel varchar(16),
   email varchar(32),
   birthday date,
   PRIMARY KEY (aid)
);

# 유저 테이블 생성 
CREATE TABLE users
(
   uid varchar(12) NOT NULL,
   pwd char(60) NOT NULL,
   uname varchar(16) NOT NULL,
   email varchar(32),
   regDate date DEFAULT (CURRENT_DATE),
   isDeleted int DEFAULT 0,
   PRIMARY KEY (uid)
);

/*
* 2. 테이블 조회
*/

SHOW TABLES;

/*
3. 테이블 삭제
*/
# largeCity view 삭제 
drop view largeCity;

# dateTable 삭제
DROP TABLE dateTable;

# kcity 테이블의 모든 데이터 삭제 
truncate kcity;


/*
4. 테이블 이름변경- 테이블 명은 대문자 x 
*/
RENAME TABLE kcity TO korCity;

/*
5. 테이블 구조 변경 
*/
# users 테이블에서 eamail 뒤에 tel 추가
ALTER TABLE users 
   ADD tel varchar(16) NOT NULL after email;

# users 테이블에서 tel 필드의 not null 제거 
ALTER TABLE users 
   change tel tel varchar(16);


