import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.PersonService;


public class Test {

	
	public static void main(String[] args) {
		//ʵ����Spring����
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//����id��������ȡBean����,Ĭ��idΪ��������ĸ��Сд
		PersonService personService = (PersonService)ctx.getBean("personServiceBean");
		//ִ��personService��save����
		personService.save();
		
	}

}
