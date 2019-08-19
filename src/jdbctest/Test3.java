package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import neuedu.entity.UserInfo;
/**
 * java .sql .  �� ר��ʵ�� ���ݿ⽻��
 * 

	����в�������
 * @author Administrator
 *
 */
public class Test3 {

	public static void main(String[] args) {
		Connection con = null;//���������������õ�
		PreparedStatement pstat = null; // Ԥ�����sql���װ����,����ͨstatement���������ڴ��ݲ���ʱ,����ȫ�͸�Ч
		
		List<UserInfo> list = new ArrayList<UserInfo>();
		
		try {
			//1.����mysql���ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.��ȡ���ݿ�ػ�
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb02", "root", "123456");
			
			System.out.println("�������ݿ����ӳɹ�!");
			
			//3.װ��һ����ѯ��sql���
			String sql = "insert into userinfo(username,pass) values(?,?)";	
			pstat = con.prepareStatement(sql);
			pstat.setObject(1, "������");
			pstat.setObject(2, "456");
			
			
			int i = pstat.executeUpdate();//ִ��һ�������¼�¼�Ĳ���,����һ��Ӱ�������
			
			System.out.println("Ӱ����"+i+"������");
			
			
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��!");
			e.printStackTrace();
		} finally {
			// �ر�˳��  rs  -> stat  -> con
			try {
				if(null!=pstat){
					pstat.close();
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
