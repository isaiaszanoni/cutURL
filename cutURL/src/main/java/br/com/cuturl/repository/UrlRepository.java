package br.com.cuturl.repository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cuturl.model.Url;

public interface UrlRepository extends JpaRepository<Url, Long>{
	
	default Optional<String> generateCutUrl(Long totalIds) {
		char[] url = {' ', ' ', ' ', ' ', ' '};
		
		String stringId = "00"+totalIds;
		stringId = stringId.substring(stringId.length() -3);
		url[0] = stringId.charAt(1);
		url[1]= stringId.charAt(2);
		
		Date date = new Date();
		String stringDate = date.toString();
		url[2] = stringDate.charAt(0);
		url[3] = stringDate.substring(stringDate.length() - 2).charAt(0);

		char randomLetter = ' ';
		Random r = new Random();
		String alphaNum = "abcdefghijklopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+-";
		for(int i = 0; i < 1; i++) {
			randomLetter = alphaNum.charAt(r.nextInt(alphaNum.length()));
		}
		url[4] = randomLetter;

		for (int i = 4; i > 0; i--) {
			int j = r.nextInt(i+1);
			
			char temp = url[i];
			url[i] = url[j];
			url[j] = temp;
		}
		
		String cutUrl = Arrays.toString(url)
				.replace("[", "")
				.replace(",", "")
				.replace(" ", "")
				.replace("]", "");
		
		return Optional.of(cutUrl);
		
	}
	
	default Optional<String> generateShortenedUrl(String originalUrl, String cutUrl) {
		String shortenedUrl = "";
		if(originalUrl.charAt(originalUrl.length() -1) == '/' ) {
			shortenedUrl = originalUrl + cutUrl;
		} else {
			shortenedUrl = originalUrl + "/" + cutUrl;
		}
		
		return Optional.of(shortenedUrl);
	}
	

}
