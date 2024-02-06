package mysql.song;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		SongDao songDao = new SongDao();

		System.out.println("getSongBySid=================");

		Song song = songDao.getSongBySid(101);
		System.out.println(song);


		System.out.println("insertSong=================>");

		song = new Song("Pure Imagenation", "come with me");
		songDao.insertSong(song);

		System.out.println("updateSong=================>");
		
		song = songDao.getSongBySid(117); // song 테이블에서 id로 레코드 불러오기 
		
		song.setTitle("Pure Imagenation");
		song.setLyrics("in a world of pure imagination"); // 레코드의 가사 변경
		
		songDao.updateSong(song); // 업데이트
		
		System.out.println("deleteSong=================>");
		
		songDao.deleteSong(115);
		
		System.out.println("getSongList=================");
		
		List<Song> list = songDao.getSongList();
		list.forEach(x -> System.out.println(x));
	}
}
