package com.example.ejercicionavidadretrofit.Modelos;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DataItem implements Serializable{
	private List<Object> videoGames;
	private List<Object> parkAttractions;
	private List<Object> films;
	private List<Object> shortFilms;
	private List<Object> tvShows;
	private String imageUrl;
	private String name;
	private List<Object> enemies;
	@SerializedName(value = "_id")
	private int id;
	private List<Object> allies;
	private String url;

	public void setVideoGames(List<Object> videoGames){
		this.videoGames = videoGames;
	}

	public List<Object> getVideoGames(){
		return videoGames;
	}

	public void setParkAttractions(List<Object> parkAttractions){
		this.parkAttractions = parkAttractions;
	}

	public List<Object> getParkAttractions(){
		return parkAttractions;
	}

	public void setFilms(List<Object> films){
		this.films = films;
	}

	public List<Object> getFilms(){
		return films;
	}

	public void setShortFilms(List<Object> shortFilms){
		this.shortFilms = shortFilms;
	}

	public List<Object> getShortFilms(){
		return shortFilms;
	}

	public void setTvShows(List<Object> tvShows){
		this.tvShows = tvShows;
	}

	public List<Object> getTvShows(){
		return tvShows;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEnemies(List<Object> enemies){
		this.enemies = enemies;
	}

	public List<Object> getEnemies(){
		return enemies;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAllies(List<Object> allies){
		this.allies = allies;
	}

	public List<Object> getAllies(){
		return allies;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"videoGames = '" + videoGames + '\'' + 
			",parkAttractions = '" + parkAttractions + '\'' + 
			",films = '" + films + '\'' + 
			",shortFilms = '" + shortFilms + '\'' + 
			",tvShows = '" + tvShows + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",name = '" + name + '\'' + 
			",enemies = '" + enemies + '\'' + 
			",_id = '" + id + '\'' + 
			",allies = '" + allies + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}