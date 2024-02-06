package ch06_class.Q;

import java.util.ArrayList;
import java.util.List;

import ch06_class.melon.MelonChart;

public class MelonMain {

	public static void main(String[] args) {
		Melon [] melon = { new Melon (1, "비의 랩소디","임재현", "비의 랩소디", 33193),
				new Melon (2, "To X","태연", "To. X - The 5th Mini Album", 82783),
				new Melon (3, "Perfect Night","LE SSERAFIM (르세라핌)", "Perfect Night", 94989),
				new Melon (4, "Drama","aespa", "Drama - The 5th Mini Album", 68543),
				new Melon (5, "에피소드", "이무진", "에피소드", 33230)
		};
		
		
		
		for(Melon sing:melon) {
			System.out.println(sing);
		}
		

	}

}
