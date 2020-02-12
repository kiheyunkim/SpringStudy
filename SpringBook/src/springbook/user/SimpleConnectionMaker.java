package springbook.user;
import java.sql.SQLException;
import java.sql.Connection;

public interface SimpleConnectionMaker {
	public Connection makeNewConnection() throws SQLException;
}
