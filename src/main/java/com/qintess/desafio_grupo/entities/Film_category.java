package com.qintess.desafio_grupo.entities;

public class Film_category {

    private Integer film_id;
    private Integer category_id;
    private String last_update;

    public Film_category() {
    }

    public Film_category(Integer film_id, Integer category_id, String last_update) {
        this.film_id = film_id;
        this.category_id = category_id;
        this.last_update = last_update;
    }

    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}
