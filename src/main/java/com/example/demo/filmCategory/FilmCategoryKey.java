package com.example.demo.filmCategory;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class FilmCategoryKey implements Serializable {

    @Column(name = "film_id")
    Integer filmId;

    @Column(name = "category_id")
    Integer categoryId;

    // standard constructors, getters and setters
    // hashcode and equals implementation

}
