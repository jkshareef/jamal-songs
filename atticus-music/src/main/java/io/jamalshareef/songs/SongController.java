package io.jamalshareef.songs;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {
	
	@Autowired
	private SongService songService;
	

	@RequestMapping("/songs")
	public List<Song> getAllSongs() {
		return songService.getAllSongs();
	}
	
	@RequestMapping("/songs/{id}")
	public Song getSong(@PathVariable String id) {
		return songService.getSong(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/songs")
	public void addSong(@RequestBody @Valid Song song, BindingResult bindingResult) {
		if (!songService.genreBouncer(song.getGenre()) || bindingResult.hasErrors()) {
			return;
		}
		songService.addSong(song);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/songs/{id}")
	public void updateSong(@RequestBody @Valid Song song, BindingResult bindingResult, @PathVariable String id) {
		if (!songService.genreBouncer(song.getGenre()) || bindingResult.hasErrors()) {
			return;
		}
		songService.updateSong(id, song);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/songs/{id}")
	public void deleteSong(@PathVariable String id) {
		songService.deleteSong(id);
	}
}
