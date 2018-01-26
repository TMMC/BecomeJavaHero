package pl.edu.bogdan.training.properties;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class App4 {

	public static void main(String[] args) {
		Locale l = Locale.getDefault();
		System.out.println(l);
		l = new Locale("de", "CH");
		Locale.setDefault(l);
		System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(199889.99));
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.toString());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm EEEE dd MMMM yyyy", Locale.US);
		System.out.println(ldt.format(formatter));
	}

}
