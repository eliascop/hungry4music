package com.challenger.hungry4music.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.challenger.hungry4music.model.Artist;
import com.challenger.hungry4music.repository.ArtistRepository;

@Service 
public class ArtistService {

	@Autowired 
	private ArtistRepository artistRepository;
	
	public Artist insert(Artist artist) {			
		artist.setCreatedAt(new Date());
		return this.artistRepository.save(artist);
	}
	
	public Artist update(Long id, Artist artist) {
		Artist artistSaved = artistRepository.findById(id.intValue()).orElseThrow(() -> new RuntimeException("Artist not found"));
		
		BeanUtils.copyProperties(artist, artistSaved, "createdAt");
		
		artistSaved.setUpdatedAt(new Date());
		return artistRepository.save(artist);
	}

	public void delete(Long id) {
		artistRepository.deleteById(id.intValue());
	}

	public List<Artist> findAll(){
		return this.artistRepository.findAll();
	}
	
	public Artist findById(Long id){
		return this.artistRepository.findById(id.intValue()).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public List<Artist> findByName(String name) {

		Artist p = new Artist();
		p.setName(name);

		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name",GenericPropertyMatchers.contains().ignoreCase());

		Example<Artist> example = Example.of(p, matcher);
		return artistRepository.findAll(example);
	}
	
}
