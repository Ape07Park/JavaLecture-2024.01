package ch05_reference;

public class Q04_Path {

	public static void main(String[] args) {
		String path = "C:\\Workspace\\Java\\lesson\\src\\ch05_reference\\Q04_Path.java";
		String[] pathArr = path.split("\\\\");		// "\\" 정규표현식으로 오해
		String filename = pathArr[pathArr.length - 1];
		System.out.println(filename);

	}

}
