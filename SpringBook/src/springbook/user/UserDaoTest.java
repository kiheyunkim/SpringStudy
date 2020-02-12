package springbook.user;
import static org.junit.Assert.assertThat;
import springbook.user.*;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//테스트 실행방법을 확장할떄 사용 ->RunWith Annotation
//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")//자동으로 만들어줄 애플리케이션 컨텍스트 설정파일 위치 지정

public class UserDaoTest {
	@Autowired
	private ApplicationContext context;
	@Autowired
	private UserDao dao;
	
	private User user1;
	private User user2;
	
	@Before
	public void setUp() {
		System.out.println(this.context);
		System.out.println(this);
		this.user1 = new User("gyumee","박성철","springno1");
		this.user2 = new User("leegw700","이길원","springno2");
	}
	
	@Test
	public void addAndGet() throws SQLException,ClassNotFoundException{
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		
		User userget1 = dao.get(user1.getId());
		assertThat(userget1.getName(), is(user1.getName()));
		assertThat(userget1.getPassword(), is(user1.getPassword()));
		
		User userget2 = dao.get(user2.getId());
		assertThat(userget2.getName(), is(user2.getName()));
		assertThat(userget2.getPassword(), is(user2.getPassword()));
	}
	
	
	public static void main(String[] args) throws SQLException{
		
		JUnitCore.main("springbook.user.UserDaoTest");
		
	}
}

	