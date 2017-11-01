package pl.edu.bogdan.training.di.annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-configuration.xml");
        BeanFactory factory = context;
        ReportGenerator generator = factory.getBean(ReportGenerator.class);
        generator.format();
	}
}
