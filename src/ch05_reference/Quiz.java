package ch05_reference;

import java.lang.StringBuffer;

public class Quiz {

	public static void main(String[] args) {
		// 1. 1에서 1000사이. 에 0은 몇번, 1은 몇번, ..., 9는 몇번 사용되었는가?
		// 1) 1 ~ 1000사이의 수 만들기 및 문자열로 저장 2) 저장한 문자열에서 0 ~ 9 까지 카운트
		String str = "";
		for(int i = 0; i <=1000; i++) {
			str += i;
		}
		
		for (int i = 0; i <= 9; i++) {
		    String pattern = "[^" + i + "]";
		    int count = str.replaceAll(pattern, "").length();// replaceAll(regex,b): 정규식으로 표현 된 것을 b로 대체
		    System.out.println(i + ": " + count);
		}
		
		
		
		// 각 숫자 세기 
		
		// 2. 디지털 시계, 00:00 ~ 23:59
		// 하루동안 3이 표시되는 시간은 몇초인가?
		int displayTime = 0;
		for (int hour = 0; hour <= 23; hour++) {
		    for (int minute = 0; minute <= 59; minute++) {
		        String clock =  Integer.toString(hour) + ':' + Integer.toString(minute);
		        if (clock.indexOf("3") >= 0)
		            displayTime += 60;
		    }
		}
		System.out.println(displayTime);
		
		// 3. 두개의 세자리수를 곱해서 나온 결과가 palindrome일때
		// 가장 큰 palindrome 수와 어떤 수를 곱해서 나온 결과인가?
		
		int maxPal = 0, max1 = 0, max2 = 0;

		for (int i = 100; i <= 999; i++) {
		    for (int k = i; k <= 999; k++) {
		        int mul = i * k;
		        if (isPalindrome(mul)) {
		            if (mul > maxPal) {
		                maxPal = mul; max1 = i; max2 = k;
		            }
		        }
		        
		    }
		    
		}
		System.out.println(maxPal + "를 만들기 위한 수는 " + max1 + "," + max2);
		
		
		// 4. C:/Workspace/WebProject/03.JavaScript/ch07.표준내장객체/04.String연습.js
		// 에서 파일명(04.String연습.js)만 출력하세요.
		
		String path = "C:/Workspace/WebProject/03.JavaScript/ch07.표준내장객체/04.String연습.js";
		
		String[] newPath = path.split("/");
		System.out.println(newPath[5]);

	}
	public static boolean isPalindrome(int a) {
		String numStr = Integer.toString(a);
		return numStr.equals(new StringBuilder(numStr).reverse().toString());
		// 객체 생성: StringBuilder sb = new StringBuilder("aaa") - 문자열을 바로 넣을 수도 있다.
		// StringBuilder: StringBuilder는 변경 가능한 문자열 생성. 따라서 여러가지를 할 수 있음. Stirng은 변경 불가
	}

}
