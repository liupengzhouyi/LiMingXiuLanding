package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import neuedu.entity.UserInfo;
/**
 * java .sql .  �� ר��ʵ�� ���ݿ⽻��
 * ��ȡһ�����е�����
 * @author Administrator
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Connection con = null;//���������������õ�
		Statement stat = null;//װ��sql����õ�
		ResultSet rs = null; 
		
		List<UserInfo> list = new ArrayList<UserInfo>();
		
		try {
			//1.����mysql���ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.��ȡ���ݿ�ػ�
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb02", "root", "123456");
			
			System.out.println("�������ݿ����ӳɹ�!");
			
			//3.װ��һ����ѯ��sql���
			
//			String sql = "select * from userinfo";
			
			stat = con.createStatement();
			
			//ʹ��stat����װ��һ��sql���,�õ��Ľ������rs������
			rs = stat.executeQuery("select * from userinfo");
			
			System.out.println("�õ�����������");
			
			//�������ѭ��Ҫʹ�ù̶�д��
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
			
			
			for (UserInfo u : list) {
				u.toString();
			}
			
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��!");
			e.printStackTrace();
		} finally {
			// �ر�˳��  rs  -> stat  -> con
			try {
				if(null!=rs){
					rs.close();
				}
				if(null!=stat){
					stat.close();
				}
				if (null!=con) {			
						con.close();// �رջػ�,���jvm�ڴ�
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}

}
