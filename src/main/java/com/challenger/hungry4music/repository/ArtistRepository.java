package com.challenger.hungry4music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenger.hungry4music.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>{

}
