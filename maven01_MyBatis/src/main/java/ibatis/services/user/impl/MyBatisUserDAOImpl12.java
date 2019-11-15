package ibatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;


/*
 * Persistence Layer의 컴포넌트 
 * SqlSession을 Hasing하는 클래스
 * 1) 필드에 SqlSession을 선언
 * 2) setter로 주입 
 */
public class MyBatisUserDAOImpl12 implements UserDAO {

	private SqlSession sqlSession;
	
	
	
	
	public SqlSession getSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		System.out.println(":: "+getClass().getName()+".setSqlSession() Call...");
	}

	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert("User10.addUser", user);
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update("User10.updateUser", user);
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete("User10.removeUser", userId);
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {
		return sqlSession.selectOne("User10.getUser", userId);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		return sqlSession.selectList("User10.getUserList", user);
	}

}
