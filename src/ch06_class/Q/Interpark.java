package ch06_class.Q;

public class Interpark {
	private int rank;
	private String title;
	private String author;
	private String translator;
	private String company;
	private int price;
	
	public Interpark() {}
	
	public Interpark(int rank, String title, String author, String translator, String company, int price) {
		super();
		this.rank = rank;
		this.title = title;
		this.author = author;
		this.translator = translator;
		this.company = company;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Interpark [rank=" + rank + ", title=" + title + ", author=" + author 
				+ ((translator == null) ? "": ", translator=" + translator)
				+ ", company=" + company 
				+ ", price=" + String.format("%,d", price) + "]"; // %,d 1000단위 구분기호
	}	
	
	
	
}
