#  1) 국내 광역시도별 도시의 개수가 많은 5개 광역시도를 조회하는 SQL. 
SELECT District, COUNT(*) AS c
	FROM city 
	WHERE CountryCode='KOR'
	GROUP BY District
	ORDER BY c DESC 
	LIMIT 5;
#  2) 인구수가 800만 보다 큰 도시의 국가명, 도시명, 인구수를 조회하는 SQL 
SELECT r.Name AS 국가명, l.Name AS 도시명, l.Population AS 인구수  FROM city AS l
	JOIN country r
	ON l.CountryCode=r.Code
	WHERE l.Population > 8000000;


#  3) 아시아 대륙에서 인구수가 가장 많은 도시 Top 10을 조회하는 SQL (국가명, 도시명, 인구수)

SELECT r.Name AS 국가명, l.Name AS 도시명, l.Population AS 인구수  FROM city AS l
	JOIN country r
	ON l.CountryCode=r.Code
	WHERE r.Continent='Asia'
	ORDER BY l.Population DESC 
	LIMIT 10;


#  4) 강원도(Kang-won)에 인구가 120000인 태백시를 삽입하는 SQL. 
INSERT INTO city 
	VALUES(DEFAULT, '태백시','KOR', 'Kang-won', 120000);


#  5) Chunchon 시의 이름과 인구수를 춘천과 30만으로 변경하는 SQL. 
UPDATE city SET NAME='춘천', Population=300000 WHERE id=2365;

