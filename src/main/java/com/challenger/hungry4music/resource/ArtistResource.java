package com.challenger.hungry4music.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenger.hungry4music.model.Artist;
import com.challenger.hungry4music.service.ArtistService;

@RestController
@RequestMapping("artist")
public class ArtistResource{

	@Autowired
	private ArtistService artistService;
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(this.artistService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody Artist artist) {
		return ResponseEntity.status(HttpStatus.CREATED).body(artistService.insert(artist));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Artist artist) {
		return ResponseEntity.ok(artistService.update(id, artist));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(Long id) {
		artistService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<?> find(String name) {
		return ResponseEntity.ok(artistService.findByName(name));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) {
		return ResponseEntity.ok(artistService.findById(id));
	}

}
