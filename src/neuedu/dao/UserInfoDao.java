package neuedu.dao;

import neuedu.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {
	int addUser(UserInfo u);
	
	int delUser(Integer id);
	
	int modifyUser(UserInfo u);
	
	List<UserInfo> queryAll();
	
	UserInfo queryByExample(String username, String pass);

//	UserInfo queryById(Integer id);
	
}
