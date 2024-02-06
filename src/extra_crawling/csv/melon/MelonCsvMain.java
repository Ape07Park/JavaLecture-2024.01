package extra_crawling.csv.melon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import extra_crawling.sec03_melon.MelonChart;
import extra_crawling.sec03_melon.MelonChartService;

public class MelonCsvMain {

	public static void main(String[] args) throws Exception {
		MelonChartService melonChartService = new MelonChartService();
		
		MelonCsvUtil melonCsvUtil = new MelonCsvUtilImpl();
		
		List<MelonChart> list = melonChartService.getRanking();
		List<List<String>> melonCsvList = new ArrayList<List<String>>();
		
		for(MelonChart rk: list) {
			List<String> line = new ArrayList<String>();
			
			
			line.add(rk.getRank() + "");
			line.add(rk.getTitle());
			line.add(rk.getArtist());
			line.add(rk.getAlbum());
			line.add(rk.getImgSrc() + "");
			
			melonCsvList.add(line);	
		}
		melonCsvUtil.writeCsv("c:/Temp/melonChart.txt", melonCsvList, ",");
	}

}
