import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest {
	
	public static void main(String[] args) throws SQLException{
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		//ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao= context.getBean("userDao",UserDao.class);
		System.out.println(context.getBean("userDao",UserDao.class));
		System.out.println(context.getBean("userDao",UserDao.class));
		User user = new User();
		user.setId("whiteship");
		user.setName("백기선");
		user.setPassword("married");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록 성공");
		
		User user2 = dao.get(user.getId());
		if(!user.getName().equals(user2.getName())){
			System.out.println("Test Failed (name)");
		}
		else if(!user.getPassword().equals(user2.getPassword())) {
			System.out.println("Test Failed (password)");
		}
		else {
			System.out.println("Test Sucecess");
		}
		
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + "조회 성공");
		
	}
}

	