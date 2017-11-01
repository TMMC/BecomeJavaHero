package pl.edu.bogdan.training.di.mixed;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
				context.register(AppConfiguration.class);
				context.refresh();
		ReportGenerator generator = (ReportGenerator) context.getBean("generator1");
		generator.format();
	}
}
