package pl.edu.bogdan.training.di.annotation;

import org.springframework.stereotype.Service;

@Service
public class XmlReportFormatter implements IReportFormatter {
	public void format() {
		System.out.println("XML FORMATTER");
	}
}
