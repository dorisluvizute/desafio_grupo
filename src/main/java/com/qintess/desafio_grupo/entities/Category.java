package com.qintess.desafio_grupo.entities;

public class Category {

    private Integer category_id;
    private String name;
    private String last_update;

    public Category() {
    }

    public Category(Integer category_id, String name, String last_update) {
        this.category_id = category_id;
        this.name = name;
        this.last_update = last_update;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", name='" + name + '\'' +
                ", last_update='" + last_update + '\'' +
                '}';
    }
}
