package com.challenger.hungry4music.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Artist", catalog = "challenge")
public class Artist implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("rating")
	private Long rating;
	
	@JsonProperty("createdat")
	private Date createdAt;
	
	@JsonProperty("updatedat")
	private Date updatedAt;
	
	@JsonProperty("external_urls")
	private String externalUrls;
	
	@JsonProperty("followers")
	private Long followers;
	
	@JsonProperty("genres")
	private String genres;
	
	@JsonProperty("id")
	private String spotifyId;
	
	@JsonProperty("popularity")
	private Long popularity;	
	
	@JsonProperty("type")
	private String type;	
	
	@JsonProperty("uri")
	private String uri;
	
	public Artist() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getExternalUrls() {
		return externalUrls;
	}

	public void setExternalUrls(String externalUrls) {
		this.externalUrls = externalUrls;
	}

	public Long getFollowers() {
		return followers;
	}

	public void setFollowers(Long followers) {
		this.followers = followers;
	}


	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getSpotifyId() {
		return spotifyId;
	}

	public void setSpotifyId(String spotifyId) {
		this.spotifyId = spotifyId;
	}

	public Long getPopularity() {
		return popularity;
	}

	public void setPopularity(Long popularity) {
		this.popularity = popularity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Artist))
			return false;
		Artist other = (Artist) obj;
		return Objects.equals(id, other.id);
	}
	
}
