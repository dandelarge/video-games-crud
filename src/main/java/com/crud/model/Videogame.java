package com.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Daniel on 18/10/2016.
 */

@Entity
public class Videogame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long videogame_id;
    String title;
    String case_img;

    public Videogame() {}

    public Videogame(Long videogame_id, String title, String case_img) {
        this.videogame_id = videogame_id;
        this.title = title;
        this.case_img = case_img;
    }

    public Long getId() {
        return this.videogame_id;
    }

    public void setId(Long id) {
        this.videogame_id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCase_img() {
        return this.case_img;
    }

    public void setCase_img(String case_img) {
        this.case_img = case_img;
    }

}
