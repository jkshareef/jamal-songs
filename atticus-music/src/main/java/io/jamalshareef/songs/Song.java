package io.jamalshareef.songs;

import java.util.Arrays;
import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



//ID (should be assigned using uuid v4 at song creation)
//Name (character field between 0 and 255 characters)
//Genre (an ENUM with valid values of “Rock”, “Pop”, “Rap”, and “R&B”)
//Artist (character field between 0 and 255 characters)
//Length (in seconds)
//Song mp3 file path (text field with max length of 2056 characters)
//Ranking (an unsigned integer with valid values from 0 to 5)

public class Song {
	

	private String id;
	
	@NotNull
	@Size(min=2, max=255)
	private String name;
	
	private String genre;
	
	@NotNull
	@Size(min=2, max=255)
	private String artist;
	private int length;
	
	@NotNull
	@Size(min=2, max=2056)
	private String filepath;
	
	@NotNull
	@Min(0)
	@Max(5)
	private int ranking;
	
	
	
	public Song() {}
	
	public Song(String name, String genre, String artist, int length, String filepath, int ranking) {
		super();
		setGenre(genre);
		this.name = name;
		this.artist = artist;
		this.length = length;
		this.filepath = filepath;
		this.ranking = ranking;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId() {
		String id = UUID.randomUUID().toString().replace("-", "");
		this.id = id;
		//TODO may have duplicate ids, though extremely rare
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
		
	}
	public int getLength() {
		return length;
	}
	
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
		
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
		
	}
	
	
}
