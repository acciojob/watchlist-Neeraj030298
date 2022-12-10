package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieservice;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        movieservice.addmovie(movie);
        return  new ResponseEntity<>("New movie added sucessfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        movieservice.adddirector(director);
        return new ResponseEntity<>("New director added sucessfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addpair(@RequestParam String movie, @RequestParam String director)
    {
        movieservice.createMovieDirectorPair(movie, director);
        return new ResponseEntity<>("Movie and Director pair added sucessfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<String> moviebyname(@PathVariable String name)
    {
        movieservice.findmovie(name);
        return new ResponseEntity<>("Movie find sucessfully", HttpStatus.CREATED);
    }

    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity<String> directorbyname(@PathVariable String name)
    {
        movieservice.finddirector(name);
        return new ResponseEntity<>("Director found sucessfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-director-name/{director}")
    public ResponseEntity<String> getallmovie(@PathVariable String director)
    {
        movieservice.findmoviefromdirector(director);
        return new ResponseEntity<>("All movie from director found sucessfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<String> allmoviename()
    {
        movieservice.findallmovie();
        return new ResponseEntity<>("All movies found sucessfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deletedirector(@RequestParam String director)
    {
        movieservice.deletedirector(director);
        return new ResponseEntity<>("Director is deleted Sucessfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deletealldirectors()
    {
        movieservice.deletealldirector();
        return new ResponseEntity<>("Delete all Director Sucessfully", HttpStatus.CREATED);
    }
}
