package com.example.demo.actor;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor,Integer> {

    List<Actor> findByFirstName(String first_name);

}
