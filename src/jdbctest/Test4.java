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

	�޸ı��еļ�¼
 * @author Administrator
 *
 */
public class Test4 {

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
			String sql = "update userinfo set username=? , pass=? where id=?";	
			pstat = con.prepareStatement(sql);
			pstat.setObject(1, "�����");
			pstat.setObject(2, "789");
			pstat.setObject(3, "3");
			
			
			int i = pstat.executeUpdate();
			
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
