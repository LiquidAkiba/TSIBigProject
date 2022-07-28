package com.example.demo.filmCategory;


import com.example.demo.category.Category;
import com.example.demo.film.Film;

import javax.persistence.*;

@Entity
@Table(name="film_category")
public class FilmCategory {
    @EmbeddedId
    FilmCategoryKey id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    Film film;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    Category category;

    String name;
}
