package extra_crawling.csv.melon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MelonCsvUtilImpl implements MelonCsvUtil {

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
		
		return readCsv(filename, "," , skipLine);
	}

	@Override
	public List<List<String>> readCsv(String filename, String separator, int skipLine) {
		// TODO Auto-generated method stub
		List<List<String>> csvList = new ArrayList<List<String>>();
		BufferedReader br = null;
		int lineNo = 0;
		try {
			br = new BufferedReader(new FileReader(filename));
			
			while(true) { // 왜 true를 넣니? 무한루프 돌리기 위해
				String line = br.readLine();
				if(line == null) {
					break;
				}
				if(skipLine > lineNo++) { // ? 
					continue;
				}
				
				String[] lineArray = line.split(separator); // ,로 나누고 나눈 것 배열에 저장함
				List<String> lineList = new ArrayList<String>();
				for (String word : lineArray) {
					lineList.add(word);
				}
				csvList.add(lineList);
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
					if(i< data.size() - 1) {
						line += separator;
					}
				}
				bw.write(line + "\n"); // 끝날 때 줄바꿈
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
