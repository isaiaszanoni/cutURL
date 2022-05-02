package br.com.cuturl.repository.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.cuturl.model.Url;
import br.com.cuturl.repository.UrlRepository;
import br.com.cuturl.service.UrlService;

@Controller
public class UrlController {
	
	@Autowired
	UrlService urlService;
	
	@Autowired
	UrlRepository urlRep;
	
	@GetMapping("urls")
	public ResponseEntity<List<Url>> getAllUrls() {
		List<Url> objectList = urlRep.findAll();
		
		if(objectList.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objectList);
		}
	}
	
	@PostMapping("cuturl")
	public ResponseEntity<Url> save(@Valid @RequestBody Url newUrl) {
		Optional<Long> totalIds = Optional.of(urlRep.count());
		newUrl.setDate(totalIds.get());
		
		String cutUrl = urlRep.getCutUrl(totalIds.get()).get();
		
		
		newUrl.setCutUrl(cutUrl.toString());
		
		
		return ResponseEntity.status(201).body(urlService.save(newUrl));
	}
	
	/*
	@GetMapping("count")
	public ResponseEntity<Object> count() {
		Optional<Long> objectCount = Optional.of(urlRep.count());
		
		
		return ResponseEntity.status(200).body(objectCount);
		
	}*/
	
	
}
