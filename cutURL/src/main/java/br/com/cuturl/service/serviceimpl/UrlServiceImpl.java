package br.com.cuturl.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cuturl.model.Url;
import br.com.cuturl.repository.UrlRepository;
import br.com.cuturl.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService {

	@Autowired
	UrlRepository urlRepository;
	
	@Override
	public Url save(Url url) {
		return urlRepository.save(url);
	}
}
