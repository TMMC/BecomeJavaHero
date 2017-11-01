package pl.edu.bogdan.training.di.mixed;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class AppConfiguration {
	@Bean(name = "formatter1")
	public IReportFormatter getFormatter1() {
		return new CsvReportFormatter();
	}
	
	@Bean(name = "formatter2")
	public IReportFormatter getFormatter2() {
		return new XmlReportFormatter();
	}
	
	@Bean(name = "generator1")
	public ReportGenerator getGenerator1(@Qualifier(value="formatter1") IReportFormatter formatter) {
		return new ReportGenerator("name", formatter);
	}
	
	@Bean(name = "generator2")
	public ReportGenerator getGenerator(@Qualifier(value="formatter2") IReportFormatter formatter) {
		ReportGenerator generator = new ReportGenerator();
		generator.setFormatter(formatter);
		generator.setName("name");
		return generator;
	}
}
