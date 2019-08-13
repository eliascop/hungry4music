package com.challenger.hungry4music.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.challenger.hungry4music.model.Artist;

@Component
@EnableScheduling
public class ImportTask {
	
	@Autowired
	private ArtistService artistService;
	
	@Scheduled(fixedRate = 100000)
	public void consultarApi() {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> entityHeader;		
		
		try {
			header.add(HttpHeaders.ACCEPT,"application/json");
			header.add(HttpHeaders.CONTENT_TYPE, "application/json");
			header.add("Authorization","Bearer BQC0RyJ1cSRY03iFw2D6_mha-fBQ7FCw-m4OLnaOyNWVOgW18i9oNwvqt_7TINCnnmNOnnNIASGigkpaBmvLJP200MUFp1MHsAM2AgqR4PrkgOev_gumzDlWnz19od92t-B1MFhAgl4HDnA_kW657is4AHkLCGP5HQGvyUgQEyowR6JAWOB1UDTHGqcco5MHr0hNfiMNrYWc7SvduEpDbaGO96zaPsTtK08FC1YUwaOmvKq3SBFkn94WyMcW5H3q1Be5TAC2ehWscaF5Nw");
			entityHeader = new HttpEntity<String>(header);
			ResponseEntity<Artist[]> entity = restTemplate.exchange("https://api.spotify.com/v1/me/following?type=artist", HttpMethod.GET, entityHeader, Artist[].class);
			artistService.inserList(Arrays.asList(entity.getBody()));				
						
			
		} catch(HttpClientErrorException | HttpServerErrorException e) {
			int statusCode = e.getStatusCode().ordinal();
			System.out.println(statusCode+" "+e.getMessage());
		}
		
	}
	
}
