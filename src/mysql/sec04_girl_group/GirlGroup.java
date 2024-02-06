package mysql.sec04_girl_group;

import java.time.LocalDate;

public class GirlGroup {
	
	private int gid;
	private String name;
	private LocalDate debut;
	private int hitSongId; // Insert, Update 할 때 사용하는 필드
	
	private String hitSongTitle; // Select할 때 사용하는 필드

	public GirlGroup() {}
	
	// Insert할 때 쓰는 생성자
	public GirlGroup(String name, LocalDate debut, int hitSongId) { 
		super();
		this.name = name;
		this.debut = debut;
		this.hitSongId = hitSongId;
	}
	
	// Update 할 때 쓰는 생성자
	public GirlGroup(int gid, String name, LocalDate debut, int hitSongId) {
		super();
		this.gid = gid;
		this.name = name;
		this.debut = debut;
		this.hitSongId = hitSongId;
	}

	public GirlGroup(int gid, String name, LocalDate debut, int hitSongId, String hitSongTitle) {
		super();
		this.gid = gid;
		this.name = name;
		this.debut = debut;
		this.hitSongId = hitSongId;
		this.hitSongTitle = hitSongTitle;
	}

	// List 할 경우 사용되는 생성자
	public GirlGroup(int gid, String name, LocalDate debut, String hitSongTitle) {
		super();
		this.gid = gid;
		this.name = name;
		this.debut = debut;
		this.hitSongTitle = hitSongTitle;
	}

	public int getGid() {
		return gid;
	}


	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public int getHitSongId() {
		return hitSongId;
	}

	public void setHitSongId(int hitSongId) {
		this.hitSongId = hitSongId;
	}

	public String getHitSongTitle() {
		return hitSongTitle;
	}

	public void setHitSongTitle(String hitSongTitle) {
		this.hitSongTitle = hitSongTitle;
	}

	@Override
	public String toString() {
		return "GirlGroup [gid=" + gid + ", name=" + name + ", debut=" + debut + 
				 ", hitSongTitle=" + hitSongTitle + "]";
	}
}
