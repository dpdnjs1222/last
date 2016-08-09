package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.BoardEntity;

public class BoardDAO {
	
	Connection con;
	public BoardDAO(Connection con) {
		this.con = con;
	}
	
	public ArrayList<BoardEntity> list(){
		
		ArrayList<BoardEntity> result = null;
		try {
			String sql = "select * from board";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardEntity entity = new BoardEntity();
				entity.setArticleNum();
				entity.setArticleTitle(articleTitle);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
