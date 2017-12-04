package pl.edu.bogdan.training.di.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
    	ApplicationContext context =
    			new ClassPathXmlApplicationContext("META-INF/spring-configuration.xml");
    	
    	ReportGenerator generator1 = (ReportGenerator) context.getBean("reportGenerator1");
    	generator1.format();
    	
    	ReportGenerator generator2 = (ReportGenerator) context.getBean("reportGenerator2");
    	generator2.format();
    }
}
