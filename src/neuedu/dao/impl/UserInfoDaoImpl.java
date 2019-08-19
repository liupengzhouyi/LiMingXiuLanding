package neuedu.dao.impl;

import neuedu.dao.BaseDao;
import neuedu.dao.UserInfoDao;
import neuedu.entity.UserInfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {

	@Override
	public int addUser(UserInfo u) {
		String sql  = "insert into userinfo (username,pass,type) values(?,?)";
		Object[] params = new Object[2];
		params[0]=u.getUsername();
		params[1]=u.getPass();
		//ִ����ɾ�ĵĹ�ͨ����
		int i = executeIUD(sql, params);
		return i;
	}

	@Override
	public int delUser(Integer id) {
		String sql  = "delete from userinfo where id=?";
		Object[] params = new Object[1];
		params[0]=id;
		//ִ����ɾ�ĵĹ�ͨ����
		int i = executeIUD(sql, params);
		return i;
	}

	@Override
	public int modifyUser(UserInfo u) {
		String sql  = "update userinfo set username=? , pass=? where id=?";
		
		Object[] params = new Object[3];
		params[0]=u.getUsername();
		params[1]=u.getPass();
		params[2]=u.getId();
		
		//ִ����ɾ�ĵĹ�ͨ����
		int i = executeIUD(sql, params);
		return i;
	}

	@Override
	public List<UserInfo> queryAll() {
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			String sql="select * from userinfo";
			
			ResultSet rs = executeSelect(sql, null);
			
			//�������ѭ��ʹ�ù̶�д��
			while(rs.next()){
				UserInfo temp = new UserInfo();
				System.out.print(rs.getInt("id")+"\t");
				System.out.print(rs.getString("username")+"\t");
				System.out.print(rs.getString(3)+"\t\n");
				temp.setId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPass(rs.getString(3));
				
				//��������е�����,������һ��������
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeAll(BaseDao.con, BaseDao.pst, rs);// �ֶ��Ĺر�
		}

		
		return list;
	}

	@Override
	public UserInfo queryByExample(String username, String pass) {
		UserInfo u = new UserInfo();
		try {
			String sql ="select * from userinfo where username=? and pass=?";
			Object[] params = new Object[2];
			params[0]=username;
			params[1]=pass;
			
			ResultSet rs = executeSelect(sql, params);
			
			while (rs.next()) {
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPass(rs.getString(3));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

}
