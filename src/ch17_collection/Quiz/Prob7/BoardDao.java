package ch17_collection.Quiz.Prob7;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
		
		public List<Board> getBoardList(){
			// 보드의 내용을 집어넣음. 빈 리스트 - 반복- 내용 삽입 - 뱉기  
			List<Board> boards = new ArrayList<Board>();
			for (int i = 1; i <= 3; i++) {
				boards.add(new Board("제목" + i, "내용" + i));
			}
			return boards;
		}

}
