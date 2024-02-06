1. 2009년도에 데뷔한 걸그룹의 히트송은?
# (걸그룹 이름, 데뷔일자, 히트송 제목)

SELECT r.name, r.debut, l.title FROM song l
	INNER JOIN girl_group r  
	ON l.sid=r.hit_song_id
	WHERE r.debut between '2009-01-01' AND '2009-12-31';      # Inner 생략 가능

/* 선생님 풀이
	SELECT l.name, l.debut, r.title FROM girl_group l
	JOIN song r ON l.hit_song_id=r.sid
	WHERE l.debut LIKE '2009%';	
*/

2. 데뷔일자가 빠른 5개의 그룹의 히트송은
#(걸그룹 이름, 데뷔일자, 히트송 제목)
SELECT r.name, r.debut, l.title FROM song l
	INNER JOIN girl_group r  
	ON l.sid=r.hit_song_id
	ORDER BY r.debut 
	LIMIT 5;

/* 선생님 풀이
	SELECT l.name, l.debut, r.title FROM girl_group l
	JOIN song r ON l.hit_song_id=r.sid
	ORDER BY l.debut
	LIMIT 5;
*/
	
3. 대륙벌로 국가숫자, GNP의 합, 국가별 평균 GNP는?
SELECT Continent, COUNT(CODE) as nation,SUM(GNP) AS GNP합, round(AVG(GNP)) AS GNP평균 
    FROM country
	group by Continent;

/* 선생님 풀이
	SELECT continent, COUNT(*), round(SUM(GNP)) AS sumGnp, round(AVG(GNP)) avgGNP
	FROM country
	GROUP BY continent;
 */      

4. 아시아 대륙에서 인구가 가장 많은 도시 10개를 내림차순으로 보여줄 것
(대륙명, 국가명, 도시명, 인구수)
SELECT Continent AS 대륙명, country.Name AS 국가명, city.Name AS 도시명, 
	city.Population as 인구수 FROM city

	# city엔 생략 가능, Name은 country, city에 다 있음 
	# 따라서 어디의 Name인지 알리기 위해 country.Name으로 씀

	JOIN country ON city.countrycode=country.Code # FROM city와 country를 묶기
    # city.countrycode=country.Code가 같다면 

    
    WHERE country.Continent='Asia'
    ORDER BY 인구수 DESC
    LIMIT 10;

/* 선생님 풀이
    SELECT r.Continent , r.Name, l.Name, l.Population 
	FROM city l 
	JOIN country r ON l.CountryCode=r.Code
	WHERE r.Continent='Asia'
	ORDER BY l.Population desc
	LIMIT 10; 
*/ 

# 5. 전 세계에서 GNP가 높은 10개 국가에서 사용하는 공식언어는?
# (국가명, GNP, 언어명)
# country 테이블과 countrylanguage의 코드가 같음을 이용해 조인
# 공식언어, GNP 높은 순  

SELECT c.NAME AS 국가명, c.GNP, l.`Language` AS 언어 FROM country c 
	JOIN countrylanguage l ON c.Code = l.CountryCode
	WHERE l.IsOfficial='T'
	ORDER BY c.GNP desc
	LIMIT 10;

/* 선생님 풀이
SELECT l.Name, l.GNP, r.`Language` FROM country l
	JOIN countrylanguage r
	ON l.Code=r.CountryCode
	WHERE r.IsOfficial='T'
	ORDER BY l.GNP desc
	LIMIT 10;
*/ 
	