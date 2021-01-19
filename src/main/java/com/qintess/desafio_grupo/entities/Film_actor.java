package com.qintess.desafio_grupo.entities;

public class Film_actor {

    private Integer actor_id;
    private Integer film_id;
    private String last_update;

    public Film_actor() {
    }

    public Film_actor(Integer actor_id, Integer film_id, String last_update) {
        this.actor_id = actor_id;
        this.film_id = film_id;
        this.last_update = last_update;
    }

    public Integer getActor_id() {
        return actor_id;
    }

    public void setActor_id(Integer actor_id) {
        this.actor_id = actor_id;
    }

    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Film_actor{" +
                "actor_id=" + actor_id +
                ", film_id=" + film_id +
                ", last_update='" + last_update + '\'' +
                '}';
    }
}
