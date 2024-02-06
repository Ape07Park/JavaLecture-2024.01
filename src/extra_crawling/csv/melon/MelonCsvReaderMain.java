package extra_crawling.csv.melon;

import java.util.List;

import extra_crawling.sec03_melon.MelonChart;

public class MelonCsvReaderMain {

	public static void main(String[] args) {
		MelonCsvUtil melonCsvUtil = new MelonCsvUtilImpl();
		
		List<List<String>> melonChartList = melonCsvUtil.readCsv("c:/Temp/melonChart.txt", ",");
		
		for(List<String> line:melonChartList) {
			MelonChart chart = new MelonChart(Integer.parseInt(line.get(0)), line.get(1), line.get(2), line.get(3) 
					,line.get(4));
			System.out.println(chart);
		}

	}

}
