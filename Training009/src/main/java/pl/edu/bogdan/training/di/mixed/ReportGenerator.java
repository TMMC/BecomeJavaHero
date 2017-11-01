package pl.edu.bogdan.training.di.mixed;


public class ReportGenerator {
	private String name;
	private IReportFormatter formatter;
	
	public ReportGenerator() {
		System.out.println("Default constructor of Generator");
	}

	public ReportGenerator(String name, IReportFormatter formatter) {
		System.out.println("Constructor with arguments of Generator");
		this.name = name;
		this.formatter = formatter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Name setter in Generator");
		this.name = name;
	}

	public IReportFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(IReportFormatter formatter) {
		System.out.println("Formatter setter in Generator");
		this.formatter = formatter;
	}
	
	public void format() {
		formatter.format();
	}
}
