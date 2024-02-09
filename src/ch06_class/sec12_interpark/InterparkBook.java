package ch06_class.sec12_interpark;

public class InterparkBook {
	private int rank;
	private String title;
	private String author;
	private String translator;
	private String comapny;
	private int price;
	
	public InterparkBook() {}
	
	public InterparkBook(int rank, String title, String author, String translator, String comapny, int price) {
		super();
		this.rank = rank;
		this.title = title;
		this.author = author;
		this.translator = translator;
		this.comapny = comapny;
		this.price = price;
	}

	@Override
	public String toString() {
		return "InterparkBook [rank=" + rank + ", title=" + title + ", author=" + author + ", translator=" + translator
				+ ", comapny=" + comapny + ", price=" + price + "]";
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public String getComapny() {
		return comapny;
	}

	public void setComapny(String comapny) {
		this.comapny = comapny;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	

}
