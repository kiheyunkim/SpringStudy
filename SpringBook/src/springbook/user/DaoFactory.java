package springbook.user;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration//���ø����̼� ���ؽ�Ʈ �Ǵ� �� ���丮�� ����� ���� ������� ǥ��
public class DaoFactory {
	
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/USER?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("920kImkh223!");
		
		return dataSource;
	}
	
	@Bean	//������Ʈ ������ ����ϴ� IoC�� �޼ҵ��� ǥ��
	public UserDao userDao() {        
		UserDao userDao = new UserDao(/*connectionMaker()*/);
		//userDao.setConnectionMaker(connectionMaker());
		userDao.setDataSource(dataSource());
		return userDao;
	}
	
	@Bean
	public SimpleConnectionMaker connectionMaker() {
		//return new CountingConnectionMaker(realConnectionMaker());
		return new DConnectionMaker();
	}

}

/*
drop table users;
create table users(
id varchar(10) primary key,
name varchar(20) not null,
password varchar(10) not null
) ;
*/
