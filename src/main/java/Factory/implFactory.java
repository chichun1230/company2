package Factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface implFactory {
	static ApplicationContext a1 = new ClassPathXmlApplicationContext("sp1.xml");
	
	static ApplicationContext a2 = new AnnotationConfigApplicationContext(sp1.class);

}
