package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test1 {

	public static void main(String[] args) {
		Connection con = null;
		
		try {
			//1.����mysql���ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.��ȡ���ݿ�ػ�
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?javaweb02", "root", "123456");
			
			System.out.println("�������ݿ����ӳɹ�!");
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��!");
			e.printStackTrace();
		} finally {
			if (null!=con) {
				try {
					con.close();// �رջػ�,���jvm�ڴ�
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
	}

}
