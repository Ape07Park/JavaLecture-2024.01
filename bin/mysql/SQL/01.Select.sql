###################################################
#
# 데이터 조작 언어(DML: Data Manipulation Language)
#
###################################################

SHOW DATABASES;
/* world DB 쓸것임, 키워드는 대문자임 */
USE world;

/* DB -> table -> data */
SHOW TABLE;
DESC city;
/* record 넣을 때 Null:no면 null 허용 x, Key:PRI: 고유값 필요  

/*
* 1. select
*/


SELECT 필드명
    FROM 테이블 명
    JOIN 테이블 명
    ON 조인 조건
    WHERE 조회 조건
    GROUP BY 필드 명
    HAVING 그룹 조건
    ORDER BY 필드명 순서
    LIMIT 숫자 OFFSET 숫자;
*/

SELECT * FROM city; # city의 모든 필드

SELECT `name`, population  FROM city LIMIT 10; *필드명을 보존하고 싶을 때 `back quote` 사용

/*
* 1.1 조회 조건 WHERE
*/
SELECT * FROM city WHERE countrycode='KOR'; # 조건문  countrycode='KOR'이 있으면 가져와
SELECT * FROM city WHERE population >= 9000000;
SELECT * FROM city WHERE countrycode='KOR' and population >= 1000000; -- and 조건: AND
SELECT distinct district FROM city WHERE countrycode='KOR'; #  고유한 값: DISTINCT

# 수도권 도시(서울, 경기, 인천)
SELECT * FROM city
    WHERE district='Seoul' or district='Inchon' or district='Kyonggi';

SELECT * FROM city WHERE district IN ('Seoul','Inchon','Kyonggi');

# 경기도에서 인구수가 홀수인 도시
SELECT * FROM city WHERE district ='Kyonggi' AND 
    population % 2 = 1;

# 국내에서 인구수가 50만 ~ 100만 도시
SELECT * FROM city WHERE countrycode='KOR' AND
    population >= 500000 AND population <= 1000000;

SELECT * FROM city WHERE countrycode='KOR' AND population between 500000 AND 1000000;

# 충청남북도의 도시
SELECT * FROM city
    WHERE district='Chungchongbuk' or district='Chungchongnam';

SELECT * FROM city WHERE district LIKE 'Chungchong%'; # %: 임의의 문자, 이때는 LIKE 사용(많이 사용함)

SELECT * FROM city WHERE district LIKE 'Tae%'; -- 시티에서 디스트릭트에 Tae로 시작하는 것이 있으면 출력

/*
* 1.2 순서(Order) -ASC(Ascending: 오름차순, default), DESC(Descending: 내림차순)
*/

# 인구수가 900만 이상인 도시를 인구수의 내림차순으로 조회
SELECT * FROM city WHERE population >= 9000000  # ORDER BY 는 같이 감
    ORDER BY population DESC;

# 국내에서 인구수가 50만 ~ 100만 도시를 지역 오름차순, 인구수 내림차수으로 조회 
SELECT * FROM city WHERE countrycode='KOR' AND population between 500000 AND 1000000
    ORDER BY district ASC, population DESC; # ASC 생략 o

SELECT * FROM city WHERE countrycode='KOR' AND population between 500000 AND 1000000
    ORDER BY district, population DESC; 

/*
* 1.3 갯수
*/
#  전세계에서 인구수 탑 10 도시
SELECT * FROM city ORDER BY population DESC LIMIT 10;

#  국내 인구수 탑 5 도시
SELECT * FROM city WHERE countrycode='KOR' ORDER BY population DESC LIMIT 5;

# 국내 인구수 탑 11 ~ 20 도시
SELECT * FROM city WHERE countrycode='KOR' 
    ORDER BY population DESC 
    LIMIT 10 OFFSET 10; # 앞에서 10개 건너띄고, 10개를 보여줌
# USA 인구수 탑 10 도시
SELECT * FROM city WHERE countrycode='USA' 
    ORDER BY population DESC LIMIT 10;

/*
* 1.4 함수 
*/
# 현재 날짜와 시각
SELECT now(); # 2024-02-01 13:45:02

# 국내 도시의 갯수 - 레코드 개수 
SELECT count(*) FROM city WHERE countrycode = 'KOR'; # count(): 갯수 세기 

# 최대, 최소 - 국내 도시 중 인구수 최대, 최소 도시 
SELECT MAX(population), MIN(population) FROM city WHERE countrycode = 'KOR'; # max(): 최대 min(): 최소

# 국내 도시의 인구 평균
SELECT ROUND(AVG(population)) FROM city WHERE countrycode = 'KOR'; ROUND() : 소수점 반올림

# Aliasing: ~라고 부르겠다
SELECT ROUND(AVG(population)) AS avgPop FROM city WHERE countrycode = 'KOR'; # AS 생략 o

SELECT count(*) numCity FROM city WHERE countrycode = 'KOR';

/* 
* 1.5 그룹핑(pivot table)
*/
# 국내 광역시도별 인구수의 평균을 내림차순으로 조회
SELECT district, ROUND(AVG(population)) avgPop FROM city 
    WHERE countrycode='KOR'
    GROUP BY district
    ORDER BY avgPop DESC;  


# 도시의 개수가 많은 나라 탑 10
SELECT countrycode, count(*) numCity FROM city
    GROUP BY countrycode
    ORDER BY numCity DESC
    LIMIT 10;

# 경기도 도시 이름
SELECT `name` FROM city WHERE district='Kyonggi'
SELECT GROUP_CONCAT(`name`) cities FROM city WHERE district='Kyonggi';

# 국내 광역시도 이름 
SELECT DISTINCT district FROM city WHERE countrycode = 'KOR';

SELECT GROUP_CONCAT(district) districts FROM city WHERE countrycode = 'KOR';

/*
* 1.6 그룹핑 조건
*/ 
# 국내 도별(도시 개수 2개 이상) 인구수의 평균을 내림차순으로 조회
SELECT district, ROUND(AVG(population)) avgPop FROM city 
    WHERE countrycode='KOR'
    GROUP BY district
    HAVING count(*) >= 2 # 그룹핑 조건 - 도시 개수 2개 이상 # HAVING 조건문: 조건문을 기준으로 그룹핑
    ORDER BY avgPop DESC;  

# 국내 도시의 개수가 5개 이상인 도
SELECT district, count(*) numCity FROM city     # numCity = count(*) 
    WHERE countrycode='KOR'
    GROUP BY district
    HAVING numCity >= 5;

# 국내 도시의 개수가 5개 이상인 도의 평균 도시 인구수를 인구 평균 내림차순으로
SELECT district, ROUND(AVG(population)) avgPop FROM city 
    WHERE countrycode='KOR'
    GROUP BY district
    HAVING count(*) >= 5
    ORDER BY avgPop DESC;

# 도시 개수가 100개 이상인 국가의 도시인구 평균을 내림차순으로 정렬
SELECT countrycode, ROUND(AVG(population)) avgPop FROM city
    GROUP BY countrycode
    HAVING count(*) >= 100
    ORDER BY avgPop DESC;

# 도시 개수가 100개 이상인 국가의 도시인구 평균을 내림차순으로 정렬
SELECT countrycode, count(*) numCity, ROUND(AVG(population)) avgPop FROM city
    GROUP BY countrycode
    HAVING numCity >= 100
    ORDER BY avgPop DESC;

/*
* 1.7 join: 테이블 여러 개를 엮어서 보여 줄 때 
inner join만 잘 쓰자 
*/
# 인구수가 800만보다 큰 도시의 국가명, 도시명, 인구수(city)
SELECT country.Name, city.Name, city.Population FROM city
	JOIN country ON city.countrycode=country.Code
    WHERE city.population > 8000000;

SELECT r.Name countryName, l.Name cityName, l.Population FROM city l
    JOIN country r # inner 생략 o
    ON l.CountryCode=r.Code
    WHERE l.Population > 8000000;

# 양쪽 테이블에서 필드명이 고유한 필드는 테이블 이름 생략 o(Continent)
SELECT Continent, r.Name countryName, l.Name cityName, l.Population FROM city l
    JOIN country r 
    ON l.CountryCode=r.Code
    WHERE l.Population > 8000000;

# 아시아 대륙에서 인구수가 많은 도시 탑 10
SELECT Continent, r.Name countryName, l.Name cityName, l.Population 
	FROM city l
	JOIN country r
	ON l.CountryCode=r.Code
	WHERE r.Continent='Asia'
	ORDER BY l.Population desc
	LIMIT 10;

# 아시아의 국가 명과 공식 언어
SELECT l.name, r.`Language` FROM country l
	JOIN countrylanguage r
	ON l.Code=r.CountryCode
	WHERE l.Continent='Asia' AND r.IsOfficial='T';

# 3개의 테이블 조인
# 아시아 대륙에서 인구수가 가장 많은 탑 10 도시(city)에서 사용하는 언어(Language) 

SELECT r.Name countryName, l.Name cityName, l.Population, o.`Language` FROM city l
	JOIN country r ON l.CountryCode=r.Code
	JOIN countrylanguage o ON l.CountryCode=o.CountryCode
	WHERE r.Continent='Asia' AND o.IsOfficial='T'
	ORDER BY l.Population desc
	LIMIT 10;


/*
* 1.8 Sub Query
*/
# 국내 도시만으로 새로운 테이블을 만드는 경우 
create table if not exists kcity LIKE city;
# 데이터 집어넣기 
INSERT INTO kcity
      SELECT * FROM city WHERE countrycode='KOR';
    SELECT * FROM kcity;