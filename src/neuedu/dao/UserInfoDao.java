package neuedu.dao;

import neuedu.entity.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface UserInfoDao {
	// 添加用户
    int addUser(UserInfo u) throws SQLException, ClassNotFoundException;

	// 删除用户
	int delUser(Integer id) throws SQLException, ClassNotFoundException;

	// 更新用户
	int updateUser(UserInfo u) throws SQLException, ClassNotFoundException;

	// 获取所有普通用户
	List<UserInfo> queryAll() throws SQLException, ClassNotFoundException;

	// 登陆结果
	UserInfo landing(String username, String pass) throws SQLException, ClassNotFoundException;

	// 查看用户名
    boolean selectUser(String username) throws SQLException, ClassNotFoundException;
}
