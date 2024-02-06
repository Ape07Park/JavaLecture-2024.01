package ch06_class.Q;

public class InterparkMain {

	public static void main(String[] args) {
		Interpark [] interpark = { new Interpark(1,"진짜 쓰는 실무 엑셀","오빠두(전진권)", null, "제이펍", 18900),
				new Interpark(2,"생성형 AI 빅3 챗GPT, 미드저니, 스테이블 디퓨전","이용태(이나용태)", null, "책바세", 32000),
				new Interpark(3,"오늘부터 이모티콘 작가","강채연", null, "혜지원", 16800),
				new Interpark(4,"실용주의 프로그래머(20주년 기념판)","데이비드 토마스, 앤드류 헌트", "정지용", "인사이트", 29700),
				new Interpark(5,"클린 코드","로버트 C 마틴", "박재호", "인사이트", 29700)		
		};
		
		for(Interpark i:interpark) { 
			System.out.println(i);
		}

	}

}
