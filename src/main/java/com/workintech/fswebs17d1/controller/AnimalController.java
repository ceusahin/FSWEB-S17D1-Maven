package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class AnimalController {

    Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/animal")
    public List<Animal> getAnimalList() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/animal/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return animals.getOrDefault(id, null);
    }

    @PostMapping("/animal")
    public void addAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/animal/{id}")
    public Animal updateAnimalId(@PathVariable int id,@RequestBody Animal animal) {
        animals.put(id,animal);
        return animals.get(id);
    }

    @DeleteMapping("/animal/{id}")
    public void deleteAnimal(@PathVariable int id){
        animals.remove(id);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Animal Controller!";
    }
}
