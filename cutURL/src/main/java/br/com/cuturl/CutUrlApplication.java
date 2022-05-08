package br.com.cuturl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.hibernate.type.LocalDateTimeType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CutUrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CutUrlApplication.class, args);
		
		/*	
		LocalDateTime date = LocalDateTime.now();
		String stringDate = DateTimeFormatter.ofPattern("YYYYMMddhhmm").format(date).toString();
		System.out.println(stringDate);
		*/

		
		
	}

}
