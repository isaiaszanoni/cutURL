package br.com.cuturl.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table (name = "tb_url")
public class Url {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUrl;
	
	@NotBlank
	private String originalUrl;
	
	
	private String cutUrl;
	
	
	private String shortenedUrl;
	
	private Long date;
	
	private Boolean active = true;

	public Long getIdUrl() {
		return idUrl;
	}

	public void setIdUrl(Long idUrl) {
		this.idUrl = idUrl;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getCutUrl() {
		return cutUrl;
	}

	public void setCutUrl(String cutUrl) {
		this.cutUrl = cutUrl;
	}

	public String getShortenedUrl() {
		return shortenedUrl;
	}

	public void setShortenedUrl(String shortenedUrl) {
		this.shortenedUrl = shortenedUrl;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	

}
