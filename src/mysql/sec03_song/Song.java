package mysql.sec03_song;

public class Song {
	private int sid;
	private String title;
	private String lyric;
	
	public Song() {}

	public Song(String title, String lyric) {
		super();
		this.title = title;
		this.lyric = lyric;
	}

	public Song(int sid, String title, String lyric) {
		super();
		this.sid = sid;
		this.title = title;
		this.lyric = lyric;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	@Override
	public String toString() {
		return "Song [sid=" + sid + ", title=" + title + ", lyric=" + lyric + "]";
	}
	
}
