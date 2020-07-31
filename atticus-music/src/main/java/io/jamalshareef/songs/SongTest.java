package io.jamalshareef.songs;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SongTest {
	
	private String longName = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
			+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
			
	
	@Autowired
	private SongService songService;
	
	@Test
	public void testAddSongs() {
		Song offTheWall = new Song("Off the Wall", "POP", "Michael Jackson", 220, "users/Jamal/documents/music/off_the_wall/off_the_wall.mp3", 0);
		Song alright = new Song("Alright", "RAP", "Kendrick Lamar", 320, "users/Jamal/documents/music/to_pimp_a_butterfly/alright.mp3", 5);
		Song partition = new Song("Partition", "RANDB", "Beyonce", 360, "users/Jamal/documents/music/lemonade/partition.mp3", 6);
		
		songService.addSong(offTheWall);
		songService.addSong(alright);
		songService.addSong(partition);
		
		Assertions.assertEquals(2, songService.getAllSongs().size());
	}
	
	public void testAddSongsWithInvalidName() {
		Song offTheWall = new Song("Off the Wall", "POP", longName, 220, "users/Jamal/documents/music/off_the_wall/off_the_wall.mp3", 0);
		Song alright = new Song("Alright", "RAP", "Kendrick Lamar", 320, "users/Jamal/documents/music/to_pimp_a_butterfly/alright.mp3", 5);
		Song partition = new Song("Partition", "RANDB", "Beyonce", 360, "users/Jamal/documents/music/lemonade/partition.mp3", 6);
		
		songService.addSong(offTheWall);
		songService.addSong(alright);
		songService.addSong(partition);
		
		Assertions.assertEquals(2, songService.getAllSongs().size());
	}
	
	@Test
	public void testUpdateSongWithRank() {
		Song offTheWall = new Song("Off the Wall", "POP", "Michael Jackson", 220, "users/Jamal/documents/music/off_the_wall/off_the_wall.mp3", 0);
		Song alright = new Song("Alright", "RAP", "Kendrick Lamar", 320, "users/Jamal/documents/music/to_pimp_a_butterfly/alright.mp3", 5);
		Song partition = new Song("Partition", "RANDB", "Beyonce", 360, "users/Jamal/documents/music/lemonade/partition.mp3", 5);
		
		songService.addSong(offTheWall);
		songService.addSong(alright);
		songService.addSong(partition);
		
		String id = songService.getAllSongs().get(1).getId();
		Song offTheWall2 = new Song("Off the Wall", "POP", "Michael Jackson", 220, "users/Jamal/documents/music/off_the_wall/off_the_wall.mp3", -1);
;
		songService.updateSong(id, offTheWall2);
		
		Assertions.assertEquals(0, songService.getSong(id).getRanking());
		
	}
	
	public void testUpdateSongWithGenre() {
		Song offTheWall = new Song("Off the Wall", "POP", "Michael Jackson", 220, "users/Jamal/documents/music/off_the_wall/off_the_wall.mp3", 0);
		Song alright = new Song("Alright", "RAP", "Kendrick Lamar", 320, "users/Jamal/documents/music/to_pimp_a_butterfly/alright.mp3", 5);
		Song partition = new Song("Partition", "RANDB", "Beyonce", 360, "users/Jamal/documents/music/lemonade/partition.mp3", 5);
		
		songService.addSong(offTheWall);
		songService.addSong(alright);
		songService.addSong(partition);
		
		String id = songService.getAllSongs().get(1).getId();
		Song offTheWall2 = new Song("Off the Wall", "Unknown", "Michael Jackson", 220, "users/Jamal/documents/music/off_the_wall/off_the_wall.mp3", 0);
;
		songService.updateSong(id, offTheWall2);
		
		Assertions.assertEquals("POP", songService.getSong(id).getGenre());
	}
	
	public void testDeleteSong() {
		Song offTheWall = new Song("Off the Wall", "POP", "Michael Jackson", 220, "users/Jamal/documents/music/off_the_wall/off_the_wall.mp3", 0);
		Song alright = new Song("Alright", "RAP", "Kendrick Lamar", 320, "users/Jamal/documents/music/to_pimp_a_butterfly/alright.mp3", 5);
		Song partition = new Song("Partition", "RANDB", "Beyonce", 360, "users/Jamal/documents/music/lemonade/partition.mp3", 5);
		
		songService.addSong(offTheWall);
		songService.addSong(alright);
		songService.addSong(partition);
		
		List<Song> songs = songService.getAllSongs();
		String id = songs.get(songs.size() - 1).getId();
		
		songService.deleteSong(id);
		
		Assertions.assertEquals(2,  songService.getAllSongs().size());
		
	}

}
