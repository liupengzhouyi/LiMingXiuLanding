package neuedu.dao.impl;

import LinkDatabase.LinkMySQL.DeleteData;
import LinkDatabase.LinkMySQL.SaveData;
import LinkDatabase.LinkMySQL.SelectData;
import LinkDatabase.LinkMySQL.UpdateData;
import neuedu.dao.UserInfoDao;
import neuedu.entity.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class UserInfoDaoImpl implements UserInfoDao {

    @Override
    public int addUser(UserInfo u) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO userInfo (username, pass, type) VALUES (\'" + u.getUsername() + "\', \'" + u.getPass() + "\', " + u.getType() + ")";
        System.out.println(sql);
        SaveData saveData = new SaveData(sql);
        if (saveData.isResults()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int delUser(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "delete from userInfo where id = " + id + ";";
        DeleteData deleteData = new DeleteData(sql);
        if (deleteData.isResults()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateUser(UserInfo u) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE userInfo SET username=\'" + u.getUsername() + "\', pass=\'" + u.getPass() + "\', type=\'" + u.getType() + "\' WHERE id=1;";
        UpdateData updateData = new UpdateData(sql);
        if (updateData.isResults()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<UserInfo> queryAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from userInfo where type = 0;";
        SelectData selectData = new SelectData(sql);
        ResultSet resultSet = selectData.getResultSet();
        List<UserInfo> list = new ArrayList<UserInfo>();
        while(resultSet.next()) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(resultSet.getInt("id"));
            userInfo.setUsername(resultSet.getString("username"));
            userInfo.setPass(resultSet.getString("pass"));
            userInfo.setType(resultSet.getInt("type"));
            list.add(userInfo);
        }
        return list;
    }

    @Override
    public UserInfo landing(String username, String pass) throws SQLException, ClassNotFoundException {
        String sql = "select * from userInfo where username = \'" + username + "\' and pass = \'" + pass + "\';";
        SelectData selectData = new SelectData(sql);
        ResultSet resultSet = selectData.getResultSet();
        List<UserInfo> list = new ArrayList<UserInfo>();
        UserInfo userInfo = null;
        while(resultSet.next()) {
            userInfo = new UserInfo();
            userInfo.setId(resultSet.getInt("id"));
            userInfo.setUsername(resultSet.getString("username"));
            userInfo.setPass(resultSet.getString("pass"));
            userInfo.setType(resultSet.getInt("type"));
        }
        return userInfo;
    }

    @Override
    public boolean selectUser(String username) throws SQLException, ClassNotFoundException {
        boolean key = false;
        String sql = "select * from userInfo where username = \'" + username + "\';";
        SelectData selectData = new SelectData(sql);
        ResultSet resultSet = selectData.getResultSet();
        while(resultSet.next()) {
            key = true;
        }
        return key;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserInfo userInfo = new UserInfo();
        userInfo.setType(1);
        userInfo.setPass("111111");
        userInfo.setUsername("liupeng");
        new UserInfoDaoImpl().addUser(userInfo);
    }
}
