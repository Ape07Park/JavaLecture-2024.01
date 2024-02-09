package extra_crawling.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtilImpl implements CsvUtil {
	// * 하나만 재대로 만들면 나머진 오버로딩으로 쉽게 구현(많이 사용함)

	@Override
	public List<List<String>> readCsv(String filename) {
		return readCsv(filename, ",", 0);
	}

	@Override
	public List<List<String>> readCsv(String filename, String separator) {

		return readCsv(filename, separator, 0);
	}

	@Override
	public List<List<String>> readCsv(String filename, int skipLine) {

		return readCsv(filename, ",", skipLine);
	}

	@Override
	public List<List<String>> readCsv(String filename, String separator, int skipLine) {
		List<List<String>> csvList = new ArrayList<List<String>>();
		BufferedReader br = null;
		int lineNo = 0; // 0으로 하면 라인 넘버 먼저 증가 시키고 한다는 의미
		try {
			br = new BufferedReader(new FileReader(filename));

			while (true) {
				String line = br.readLine();
				if (line == null) { //  라인에 아무것도 없으면 반복 종룐
					break;
				}
				if (skipLine > lineNo++) {
					continue; // 몇 줄 건너띄기
				}
				String[] lineArray = line.split(separator); // split하면 array로 만듦
//				csvList.add(Arrays.asList(lineArray)); 

				// 위의 한줄 코드 풀어씀
				List<String> lineList = new ArrayList<String>();
				for (String word : lineArray) {
					lineList.add(word);
				}
				csvList.add(lineList);
				//
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return csvList;
	}

	@Override
	public void writeCsv(String filename, List<List<String>> dataList) {
		writeCsv(filename, dataList, ",");
	}

	@Override
	public void writeCsv(String filename, List<List<String>> dataList, String separator) {
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(filename));
			for (List<String> data : dataList) {
				String line = "";
				for (int i = 0; i < data.size(); i++) {
					line += data.get(i);
					if (i < data.size() - 1) {
						line += separator;
					}
				}
				bw.write(line + "\n"); // 끝날 때 줄바꿈
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 이런 식으로 하면 마지막에 에러 나는 거 잡으면서 기록 o
			try {
				bw.flush();
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
