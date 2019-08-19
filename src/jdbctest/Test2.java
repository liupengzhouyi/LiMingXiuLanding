package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbctest.entity.UserInfo;
/**
 * java .sql .  包 专门实现 数据库交互
 * 读取一个表中的数据
 * @author Administrator
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Connection con = null;//负责与数据连接用的
		Statement stat = null;//装载sql语句用的
		ResultSet rs = null; 
		
		List<UserInfo> list = new ArrayList<UserInfo>();
		
		try {
			//1.加载mysql数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.获取数据库回话
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb02", "root", "123456");
			
			System.out.println("建立数据库连接成功!");
			
			//3.装载一个查询的sql语句
			
//			String sql = "select * from userinfo";
			
			stat = con.createStatement();
			
			//使用stat对象装载一个sql语句,得到的结果放在rs对象中
			rs = stat.executeQuery("select * from userinfo");
			
			System.out.println("得到的数据如下");
			
			//结果集的循环要使用固定写法
			while(rs.next()){
				UserInfo temp = new UserInfo();
				System.out.print(rs.getInt("id")+"\t");
				System.out.print(rs.getString("username")+"\t");
				System.out.print(rs.getString(3)+"\t\n");
				temp.setId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPass(rs.getString(3));
				
				//将结果集中的内容,都放在一个集合中
				list.add(temp);
			}
			
			
			for (UserInfo u : list) {
				u.toString();
			}
			
		} catch (Exception e) {
			System.out.println("数据库连接失败!");
			e.printStackTrace();
		} finally {
			// 关闭顺序  rs  -> stat  -> con
			try {
				if(null!=rs){
					rs.close();
				}
				if(null!=stat){
					stat.close();
				}
				if (null!=con) {			
						con.close();// 关闭回话,清空jvm内存
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}

}
