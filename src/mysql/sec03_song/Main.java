package mysql.sec03_song;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		SongDao songDao = new SongDao();
		
		Song song = songDao.getSongbySid(101);
		System.out.println(song);
		
		song = songDao.getSongbyTitle("별빛");
		System.out.println(song);
		
//		song = new Song("Hypeboy", "하 하 하입보이");
		
		song = songDao.getSongbySid(117);
		song.setTitle("Hype Boy");
		song.setLyric("너 없이는 매일 매일이 yeah 재미없어 어쩌지");
		
		songDao.updateSong(song);
		
		songDao.deleteSong(116);
		
		List<Song> list = songDao.getSongListAll();
		list.forEach(x -> System.out.println(x));
		
		songDao.deleteSong(116);
		
		songDao.close();
		
		
	}

}
