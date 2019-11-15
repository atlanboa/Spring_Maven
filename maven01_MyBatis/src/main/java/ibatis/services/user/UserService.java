package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;
/*
 * Service Layer Component
 * ::
 * Service Layer는 데이터를 조작, 가공하는 것과 연관된 레이어
 * 대표적으로 페이징처리가 여기에 해당된다.
 */
public interface UserService {
	void addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
//	int removeUser(String userId) throws Exception; 가공할 이유가 없음으로
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
	
}
