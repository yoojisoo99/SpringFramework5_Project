package myspring.di.xml;


//static import
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	ApplicationContext context;
		
	@BeforeEach
	void init() {
		//Container 객체생성
		context = new GenericXmlApplicationContext("classpath:hello-bean.xml");		
	}

	@Test
	void helloBean() {
		Hello helloById = (Hello)context.getBean("hello");
		Hello helloByType = context.getBean("hello", Hello.class);
		
		//Hello SpringBeans이 Singleton 객체인지를 검증하기
		System.out.println(helloById == helloByType);
		
		assertSame(helloById, helloByType);
	}
}
