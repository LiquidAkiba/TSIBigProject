package com.example.demo.film;

import org.springframework.web.bind.annotation.*;




public class FilmApp {


    private FilmRepository filmRepository;

    public FilmApp(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    

    @PostMapping("/Add_New_Film")
    public @ResponseBody String addNewFilm(@RequestParam String first_name, @RequestParam String last_name) {
        Film f = new Film(first_name, last_name);
        System.out.println(first_name + " " + last_name);
        filmRepository.save(a);
        return "saved";
    }

    //Get request / read function
    @GetMapping("/All_Film")
    public @ResponseBody
    Iterable<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @DeleteMapping("/Delete_Film_By_Id")
    public @ResponseBody
    void deleteFilmById(@RequestParam int id) {
        filmRepository.deleteById(id);
    }

}
