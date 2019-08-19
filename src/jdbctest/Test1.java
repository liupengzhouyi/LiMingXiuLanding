package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test1 {

	public static void main(String[] args) {
		Connection con = null;
		
		try {
			//1.加载mysql数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.获取数据库回话
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?javaweb02", "root", "123456");
			
			System.out.println("建立数据库连接成功!");
		} catch (Exception e) {
			System.out.println("数据库连接失败!");
			e.printStackTrace();
		} finally {
			if (null!=con) {
				try {
					con.close();// 关闭回话,清空jvm内存
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
	}

}
