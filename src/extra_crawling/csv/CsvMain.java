package extra_crawling.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import extra_crawling.sec02_interpark_book.InterparkBook;
import extra_crawling.sec02_interpark_book.InterparkBookService;

public class CsvMain {

	public static void main(String[] args) throws IOException {

		/*
		 ** DB에서 데이터 가져올 때 이런 식으로 할 것임
		 */
		InterparkBookService interparkBookService = new InterparkBookService();

		CsvUtil csvUtil = new CsvUtilImpl();

		List<InterparkBook> list = interparkBookService.getBestSeller(); // interparkBookService의 getBestSeller()가져옴
		List<List<String>> csvList = new ArrayList<List<String>>();
		
		for (InterparkBook ib : list) { // InterparkBook을 List<String>으로 변경
			List<String> line = new ArrayList<String>(); // 한 줄 짜리 받아오기

			// line에 내용들 추가
			line.add(ib.getRank() + "");
			line.add(ib.getTitle());
			line.add(ib.getAuthor());
			line.add(ib.getCompany());
			line.add(ib.getPrice() + "");

			// csvList에 line 추가
			csvList.add(line);
		}
		csvUtil.writeCsv("c:/Temp/interpark.tsv", csvList, "\t"); // "\t" : tap

	}

}
