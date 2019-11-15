package model;

import java.sql.SQLException;

public interface MemberDAO {

	boolean loginCheck(String user, String pass) throws SQLException;

	void add(Member m) throws Exception;

}