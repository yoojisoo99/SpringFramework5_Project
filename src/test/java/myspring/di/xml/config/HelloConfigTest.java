package myspring.di.xml.config;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloConfig.class)
public class HelloConfigTest {
	@Autowired
	Hello hello;
	
	@Resource(name="stringPrinter")
	Printer printer;
	
	@Test
	void hello() {
		assertEquals("Hello 자바컨피그", hello.sayHello());
		hello.print();
		assertEquals("Hello 자바컨피그", printer.toString());
	}
}
