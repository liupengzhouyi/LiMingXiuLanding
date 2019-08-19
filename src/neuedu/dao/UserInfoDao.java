package neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserInfo;

public interface UserInfoDao {
	int addUser(UserInfo u);
	
	int delUser(Integer id);
	
	int modifyUser(UserInfo u);
	
	List<UserInfo> queryAll();
	
	UserInfo queryByExample(String username, String pass);
//	
//	UserInfo queryById(Integer id);
	
}
