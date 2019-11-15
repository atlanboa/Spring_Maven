package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;


public class MemberDAOImpl implements MemberDAO {
	private static MemberDAOImpl mdao = new MemberDAOImpl();
	private MemberDAOImpl() {}
	public static MemberDAOImpl getInstance() {
		return mdao;
	}
 
	/* (non-Javadoc)
	 * @see com.ssafy.model.IMemberDAO#loginCheck(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean  loginCheck(String user, String pass) throws SQLException{
		//boolean flag=false;
		Connection con=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		String q="Select pw from Member where id=?";
		try{
			con=DBUtil.getConnection();
			ps=con.prepareStatement(q);
			ps.setString(1, user);
			rs=ps.executeQuery();
			if(rs.next()){
				String pw=rs.getString(1);
				if(pw.equals(pass)){
					return true;
				}							
			}			
		}finally{
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}	
		return false;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IMemberDAO#add(com.ssafy.model.Member)
	 */
	@Override
	public void add(Member m) throws Exception {
		Connection con=null;
		PreparedStatement ps= null;
		String q="Insert into Member values(?,?,?,?,?,?,?,?)";
		try{
			con=DBUtil.getConnection();
			ps=con.prepareStatement(q);
			
			ps.setString(1, m.getId());
			ps.setString(2, m.getPw());
			ps.setString(3, m.getName());
			ps.setString(4, m.getNickName());
			ps.setString(5, m.getEmail());
			ps.setString(6, m.getHomePage());
			ps.setString(7, m.getAddress());
			ps.setString(8, m.getHobby());
			
			ps.executeUpdate();		
			System.out.println("회원 가입 완료");
		}finally{
			DBUtil.close(ps);
			DBUtil.close(con);
		}		
	}
	
}







