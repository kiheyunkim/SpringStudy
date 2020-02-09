import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserDao {
	//private SimpleConnectionMaker simpleConnectionMaker;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//public void setConnectionMaker(SimpleConnectionMaker connectionMaker) {
	//	this.simpleConnectionMaker = connectionMaker;
	//}
	
	public UserDao(/*SimpleConnectionMaker connectionMaker*/) {
		//simpleConnectionMaker = connectionMaker;
	}
	
	public void add(User user)  throws SQLException {
		//Connection conn = simpleConnectionMaker.makeNewConnection();
		Connection conn = dataSource.getConnection();
		
		System.out.println(conn.toString());
		
		PreparedStatement ps = conn.prepareStatement("insert into users(id,name,password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public User get(String id) throws SQLException {
		//Connection conn = simpleConnectionMaker.makeNewConnection();
		Connection conn = dataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		conn.close();
		
		return user;
	}

	/*
	    create table users(
		id varchar(10) primary key,
		name varchar(20) not null,
		password varchar(10) not null
		) ;
	 */
	
}
