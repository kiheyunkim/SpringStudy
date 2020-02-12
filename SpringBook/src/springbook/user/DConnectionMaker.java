package springbook.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements SimpleConnectionMaker{

	public Connection makeNewConnection() throws SQLException {

		Connection c = null;
		String url = "jdbc:mysql://127.0.0.1:3306/USER?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		c = DriverManager.getConnection(url,"root","920kImkh223!");
		
		return c;
	}

}
