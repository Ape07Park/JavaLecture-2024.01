###################################################
#
# 테이블 EXport/Import
#
###################################################

/* 
* 1. secure_file_priv 확인 
C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\ - Windows
Export시 이 위치에 있어야 함
이 위치에 있어야 파일 다운 가능 
*/
SHOW VARIABLES LIKE 'secure_file_priv';


/*
* 2. Export(Table -> FIle) : 백업 
*/ 
SELECT * FROM song INTO OUTFILE 
	'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/song.csv'
	FIELDS TERMINATED BY ',' -- 구분자 ,로
	ENCLOSED BY '"' -- 양쪽 데이터 필드는 " 로
	LINES TERMINATED BY '\n';

/*
* 3. Import(File -> Table)
*/ 
# 데이터 삭제
truncate song;

# 데이터 로드
LOAD DATA INFILE 
	'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/song.csv'
	INTO TABLE song 
	FIELDS TERMINATED BY ',' -- 구분자 ,로
	ENCLOSED BY '"' -- 양쪽 데이터 필드는 " 로
	LINES TERMINATED BY '\n';

# 데이터 확인 
SELECT * FROM song;

