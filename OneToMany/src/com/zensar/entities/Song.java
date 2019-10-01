package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author RAHUL BANGALORE SRIDHAR
 * @version 1.0
 * @creation date 27th sept 2019 16.41pm
 * @modification date 27th sept 2019 16.42pm
 * @description
 *
 */

@Entity
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int songId;
	public Song(String songName) {
		super();
		this.songName = songName;
	}

	private String songName;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;

	public Song() {
		// TODO Auto-generated constructor stub
	}

	public Song(int songId, String songName) {
		super();
		this.songId = songId;
		this.songName = songName;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + "]";
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	

}
