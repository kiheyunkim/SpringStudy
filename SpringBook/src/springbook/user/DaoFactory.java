package springbook.user;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration//어플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정 정보라는 표시
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
	
	@Bean	//오브젝트 생성을 담당하는 IoC용 메소드라는 표시
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
