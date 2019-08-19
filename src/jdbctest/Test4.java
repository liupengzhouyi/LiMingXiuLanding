package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbctest.entity.UserInfo;
/**
 * java .sql .  包 专门实现 数据库交互
 * 

	修改表中的记录
 * @author Administrator
 *
 */
public class Test4 {

	public static void main(String[] args) {
		Connection con = null;//负责与数据连接用的
		PreparedStatement pstat = null; // 预编译的sql语句装载器,比普通statement的优势在于传递参数时,更安全和高效
		
		List<UserInfo> list = new ArrayList<UserInfo>();
		
		try {
			//1.加载mysql数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.获取数据库回话
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb02", "root", "123456");
			
			System.out.println("建立数据库连接成功!");
			
			//3.装载一个查询的sql语句
			String sql = "update userinfo set username=? , pass=? where id=?";	
			pstat = con.prepareStatement(sql);
			pstat.setObject(1, "王天财");
			pstat.setObject(2, "789");
			pstat.setObject(3, "3");
			
			
			int i = pstat.executeUpdate();
			
			System.out.println("影响了"+i+"行数据");
			
			
		} catch (Exception e) {
			System.out.println("数据库连接失败!");
			e.printStackTrace();
		} finally {
			// 关闭顺序  rs  -> stat  -> con
			try {
				if(null!=pstat){
					pstat.close();
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
