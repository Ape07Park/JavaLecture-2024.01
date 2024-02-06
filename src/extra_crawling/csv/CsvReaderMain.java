package extra_crawling.csv;

import java.util.List;

import extra_crawling.sec02_interpark_book.InterparkBook;

public class CsvReaderMain {

	public static void main(String[] args) {
		CsvUtil csvUtil = new CsvUtilImpl();
		// "c:/Temp/interpark.tsv"에 있는 거 읽어오기(,로 구분 및 라인 스킵 시 탭)
		List<List<String>> csvList = csvUtil.readCsv("c:/Temp/interpark.tsv", "\t");

		// 인터파크북 자료형으로 만들기
		for (List<String> line : csvList) {

			// 인터파크북 자료형(리스트)에 랭크 등 넣기
			InterparkBook ib = new InterparkBook(Integer.parseInt(line.get(0)), line.get(1), line.get(2), line.get(3),
					Integer.parseInt(line.get(4)));
			System.out.println(ib);
		}
	}

}
