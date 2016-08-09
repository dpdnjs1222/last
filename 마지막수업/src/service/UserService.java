package service;

import java.sql.Connection;

import dao.UserDAO;

public class UserService {

	//원래는 entity 만들어야 하지만 우리는 귀찮아서 안쓸것임!
	
	// transaction은 논리적인 작업의 단위를 지정
	// service안의 method는 하나의 단위작업을 수행
	// 일반적으로 이런 하나의 단위작업은 여러개의 SQL문장을 수행
	//transaction처리는 java에서 connection단위로 처리 -> service에서 connection이 이루어져야 한다
	public boolean login(String id, String pw){
		Connection con = common.DBTemplate.getConnection();
		
		UserDAO dao = new UserDAO(con);
		boolean result = dao.select(id, pw);
		// 여기는 1개만 호출하지만 실제로 여러개의 dao method가 호출된다
		
		
		try {
			if(result){
				con.commit();
			}else{
				con.rollback();
			}
			// connection pool한테 connection을 돌려준다
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}
}
