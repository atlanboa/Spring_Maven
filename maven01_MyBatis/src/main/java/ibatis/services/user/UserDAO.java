package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;

//비지니스 로직의 템플릿 들어있다.
public interface UserDAO {
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser(String userId) throws Exception;
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
	
}
