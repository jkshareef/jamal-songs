package io.jamalshareef.songs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//Create a song
//Delete a song
//Play a song
//Update a song
//
//Please follow ReST standards for endpoint method (POST, PUT, DELETE, GET, etc) 
//when implementing the endpoints.

//public Song(String name, String genre, String artist, 
//int length, String filepath, int ranking)

@Service
public class SongService {
	
	
	private List<Song> songs = new ArrayList<>();
	private enum Genre {
		ROCK, POP, RAP, RANDB;
	}
	
	public List<Song> getAllSongs() {
		return songs;
	}
	
	public Song getSong(String id) {
		for (Song song: songs) {
			if (song.getId().equals(id)) {
				//TODO return bitstream of file with helper function (assumed to be provided) in addition to the song object below
				return song;
				
			}
		}
		return null;
	}
	
	public void addSong(Song song) {
		song.setId();
		songs.add(song);
		
	}

	public void updateSong(String id, Song song) {
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getId().equals(id)) {
				songs.set(i, song);
				return;
			}
		}
	}

	public void deleteSong(String id) {
		songs.removeIf(s -> s.getId().equals(id));
	}
	
	public boolean genreBouncer(String genre) {
		return Arrays.stream(Genre.values()).anyMatch((t) -> t.name().equals(genre));
	}
	


}
