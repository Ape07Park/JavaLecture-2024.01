package extra_crawling.sec03_melon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Attr;

public class MelonChartService {
	public List<MelonChart> getRanking() throws IOException{
		String url = "https://www.melon.com/chart/index.htm";
		Document doc = Jsoup.connect(url).get();
		Elements trs = doc.select(".service_list_song.type02.d_song_list > table > tbody > tr");
		// 완료
		List<MelonChart> list = new ArrayList<MelonChart>();
		// 완료
		
		for (Element tr : trs) {
			Elements spans = tr.select(".wrap.t_center.rank");
			String rank_ = tr.selectFirst(".rank").text().strip();

			for (Element span : spans) {
				String s = span.attr("class").strip();
				rank_ += s.charAt(s.length() - 1);
			}
			
			int rank = Integer.parseInt(rank_);
			//
			
			String title = tr.selectFirst(".ellipsis.rank01 > span > a").text().strip();
			String artist = tr.selectFirst(".ellipsis.rank02 > a").text().strip();
			String album = tr.selectFirst(".ellipsis.rank03 > a").text().strip();
			String src = tr.selectFirst("td:nth-child(4) > div > a > img").attr("src");
			
			MelonChart chart = new MelonChart(rank, title, artist, album, src);
			list.add(chart);
		
		}
		return list;
		
	}
}
