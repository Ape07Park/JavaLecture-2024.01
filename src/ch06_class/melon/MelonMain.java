package ch06_class.melon;

import java.util.List;
import java.util.ArrayList;

public class MelonMain {

	public static void main(String[] args) {
		// 기본 생성자로 객체를 생성하고, Setter로 필드값을 설정
		MelonChart melonChart = new MelonChart();
		melonChart.setRank(1); melonChart.setTitle("비의 랩소디"); melonChart.setArtist("임재현");
		melonChart.setAlbum("비의 랩소디"); melonChart.setLike(33785);
//		System.out.println(melonChart);
		
		// 필드값을 객체를 생성할 때 부여
		MelonChart melonChart2 = new MelonChart(2, "To. X", "태연", "To. X", 83812);
		
		MelonChart[] melonChartArray = {melonChart, melonChart2,
				new MelonChart(3, "Perfect Night", "르세라핌", "Perfect Night", 95252),
				new MelonChart(4, "에피소드", "이무진", "에피소드", 33816),
				new MelonChart(5, "Drama", "aespa", "Drama", 68790)
		};
		
		for (MelonChart mc: melonChartArray)
			System.out.println(mc);
		
		// 실전에서 사용하는 코드
		List<MelonChart> list = new ArrayList<>();
		list.add(melonChart); list.add(melonChart2);
		list.add(new MelonChart(3, "Perfect Night", "르세라핌", "Perfect Night", 95252));
		list.add(new MelonChart(4, "에피소드", "이무진", "에피소드", 33816));
		list.add(new MelonChart(5, "Drama", "aespa", "Drama", 68790));
//		for (MelonChart mc: list)
//			System.out.println(mc);
		list.forEach(x -> System.out.println(x));
	}

}
