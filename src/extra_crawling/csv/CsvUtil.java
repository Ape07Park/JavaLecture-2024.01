package extra_crawling.csv;

import java.util.List;

public interface CsvUtil {

	List<List<String>> readCsv(String filename); 

	List<List<String>> readCsv(String filename, String separator);

	List<List<String>> readCsv(String filename, int skipLine);

	List<List<String>> readCsv(String filename, String separator, int skipLine); // 열 단위, 행 단위 리스트

	void writeCsv(String filename, List<List<String>> dataList); // separator 안주면 separator 기본값 0으로 처리. 이 라인 거 쓸 수 있도록
																	// * 오버로딩

	void writeCsv(String filename, List<List<String>> dataList, String separator);
}
