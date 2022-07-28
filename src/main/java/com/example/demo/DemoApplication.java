package com.example.demo;

import com.example.demo.actor.Actor;
import com.example.demo.actor.ActorRepository;
import com.example.demo.category.Category;
import com.example.demo.category.CategoryRespository;
import com.example.demo.film.Film;
import com.example.demo.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins="*")
@SpringBootApplication
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/Sakila")
public class DemoApplication {
	@Autowired
	private ActorRepository actorRepository;
	private FilmRepository filmRepository;
	private CategoryRespository categoryRespository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public DemoApplication(ActorRepository actorRepository, FilmRepository filmRepository, CategoryRespository categoryRespository){
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
		this.categoryRespository = categoryRespository;
	}

	//@ResponseBody
	@PostMapping("/Add_New_Actor")
	public @ResponseBody String addNewActor(@RequestParam String firstName, @RequestParam String lastName){
		Actor a = new Actor(firstName, lastName);
		System.out.println(firstName + " " + lastName);
		actorRepository.save(a);
		return "saved";
	}

	//Get request / read function
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@DeleteMapping("/Delete_Actor_By_Id")
	public @ResponseBody
	void deleteActorById(@RequestParam int id){
		actorRepository.deleteById(id);
	}

	// get actor by name
	@GetMapping("/Get_Actor_By_First_Name")
	public @ResponseBody
	Iterable<Actor> getActorByFirstName(@RequestParam String first_name) {
		return actorRepository.findByFirstName(first_name);
	}

	// get all films
	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms() {
		return filmRepository.findAll();
	}

	// get films by category
	@GetMapping("/Get_Films_By_Category")
	public @ResponseBody
	List<Film> getFilmsByCategory(@RequestParam String category) {
		return filmRepository.findByFilmCategory_Name(category);
	}

	// get all categories
	@GetMapping("/All_Categories")
	public @ResponseBody
	Iterable<Category>getAllCategories() {
		return categoryRespository.findAll();
	}

	// get film by title
	@GetMapping("Get_Film_By_Title")
	public @ResponseBody
	Iterable<Film>getFilmByTitle(@RequestParam String title) {
		return filmRepository.findByTitle(title);
	}

	// find rental rate of specific film
	@GetMapping("Get_Rental_Rate_Of_Film")
	public @ResponseBody
	Double getRentalRateOfFilm(@RequestParam String title) {
		return filmRepository.findByTitle(title).get(0).getRentalRate();
	}

	// create a new account
//    @PostMapping("Add_New_Customer")
//    public @ResponseBody
//    void addNewCustomer() {
//    }
}
