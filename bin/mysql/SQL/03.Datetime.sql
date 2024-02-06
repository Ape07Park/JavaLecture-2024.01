###################################################
#
# 날짜/시간 조작
#
###################################################

/*
1. 테이블 생성
*/

create TABLE if NOT EXISTS dateTable(
    id INT primary KEY AUTO_INCREMENT,
    regDate DATE default (CURRENT_DATE), # 날짜 
    modTime DATETIME default current_timestamp  # 날짜 + 시간
);


/*
2. 데이터 입력
*/
INSERT INTO dateTable VALUES (default, default, default);
INSERT INTO dateTable(id) VALUES (DEFAULT);

INSERT INTO dateTable(regDate, modTime) VALUES
    ('2024-01-01', '2024-01-31 10:25:00'),
    ('2024-02-01', '2024-02-02 16:45:00');


/*
3. 데이터 조회
*/

# 2024-02-02 형식
SELECT regDate, date_format(modTime, '%Y-%m-%d') FROM dateTable;

# 10:45:00 AM 형식
SELECT date_format(modTime, '%h:%i:%s:%p') FROM dateTable;


# 24-02-02 16:45 형식 
SELECT date_format(modTime, '%y-%m-%d %H:%i') FROM dateTable;

# 날짜 조회 함수
SELECT NOW(), CURDATE(), CURTIME();

/*
4. 데이터 수정
*/

UPDATE datetable SET regdate=CURDATE() WHERE  id=3;


UPDATE datetable SET regdate=CURDATE(), modTime=NOW() WHERE id=3;

/*
5. 날짜 계산 
*/
# 날짜 더하기 / 빼기 
SELECT DATE_ADD(NOW(), INTERVAL 40 DAY); # 더하기 

SELECT DATE_SUB(NOW(), INTERVAL 3 MONTH); # 빼기 

# D-day 계산 
SELECT TO_DAYS('2024-11-14') - TO_DAYS(CURDATE()); 

# 요일: 1- 일요일 
SELECT DAYOFWEEK (regDate) FROM datetable;

