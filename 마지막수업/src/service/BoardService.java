package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import entity.BoardEntity;

public class BoardService {
	
	public ArrayList<BoardEntity> list(){
		//게시판 리스트를 출력하는 서비스
		
		Connection con = common.DBTemplate.getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		ArrayList<BoardEntity> result = null;
		return result;
	}
}
