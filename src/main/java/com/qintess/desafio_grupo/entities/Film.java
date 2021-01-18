package com.qintess.desafio_grupo.entities;

public class Film {

	private Integer film_id;
	private String title;
	private String description;
	private Integer release_year;
	private Integer language_id;
	private Integer rental_duration;
	private Double rental_rate;
	private Integer lenght;
	private Double replacement_cost;
	private String rating;
	private String last_update;
	private String special_features;
	private String fulltext;

	public Film() {}

	public Film(Integer film_id, String title, String description, Integer release_year, Integer language_id,
			Integer rental_duration, Double rental_rate, Integer lenght, Double replacement_cost, String rating,
			String last_update, String special_features, String fulltext) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.language_id = language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.lenght = lenght;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.last_update = last_update;
		this.special_features = special_features;
		this.fulltext = fulltext;
	}

	public Integer getFilm_id() {
		return film_id;
	}

	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRelease_year() {
		return release_year;
	}

	public void setRelease_year(Integer release_year) {
		this.release_year = release_year;
	}

	public Integer getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(Integer language_id) {
		this.language_id = language_id;
	}

	public Integer getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(Integer rental_duration) {
		this.rental_duration = rental_duration;
	}

	public Double getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(Double rental_rate) {
		this.rental_rate = rental_rate;
	}

	public Integer getLenght() {
		return lenght;
	}

	public void setLenght(Integer lenght) {
		this.lenght = lenght;
	}

	public Double getReplacement_cost() {
		return replacement_cost;
	}

	public void setReplacement_cost(Double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getLast_update() {
		return last_update;
	}

	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	public String getFulltext() {
		return fulltext;
	}

	public void setFulltext(String fulltext) {
		this.fulltext = fulltext;
	}

	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", title=" + title + ", description=" + description + ", release_year="
				+ release_year + ", language_id=" + language_id + ", rental_duration=" + rental_duration
				+ ", rental_rate=" + rental_rate + ", lenght=" + lenght + ", replacement_cost=" + replacement_cost
				+ ", rating=" + rating + ", last_update=" + last_update + ", special_features=" + special_features
				+ ", fulltext=" + fulltext + "]";
	}
	
	






}
