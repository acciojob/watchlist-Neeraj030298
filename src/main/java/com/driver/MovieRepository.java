package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String, Director> DirectorMapping;
    HashMap<String, Movie> Moviemapping;
    HashMap<String, List<String>> DirectorMoviePair;

    public MovieRepository() {
        this.DirectorMapping = new HashMap<>();
        this.Moviemapping = new HashMap<>();
        this.DirectorMoviePair = new HashMap<String, List<String>>();
    }

    public void addMovie(Movie movie) {
        Moviemapping.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        DirectorMapping.put(director.getName(), director);
    }

    public void saveDirectorMoviePair(String movie, String director) {
        if (Moviemapping.containsKey(movie) && DirectorMapping.containsKey(director)) {
            List<String> currentList = new ArrayList<>();
            if (DirectorMoviePair.containsKey(movie)) currentList = DirectorMoviePair.get(director);
            currentList.add(movie);
            DirectorMoviePair.put(director, currentList);
        }
    }

    public Movie findMovie(String movie) {
        return Moviemapping.get(movie);
    }

    public Director findDirector(String director) {
        return DirectorMapping.get(director);
    }

    public List<String> findMovieFromDirector(String director) {
        List<String> movieList = new ArrayList<>();
        if (DirectorMoviePair.containsKey(director)) movieList = DirectorMoviePair.get(director);
        return movieList;
    }

    public List<String> findAllMovie() {
        return new ArrayList<>(Moviemapping.keySet());
    }

    public void deleteDirector(String director) {
        List<String> movies = new ArrayList<>();
        if (DirectorMoviePair.containsKey(director)) {
            movies = DirectorMoviePair.get(director);
            for (String movie : movies) {
                if (Moviemapping.containsKey(movie)) Moviemapping.remove(movie);
            }
            DirectorMoviePair.remove(director);
        }
        if (DirectorMapping.containsKey(director))
            DirectorMapping.remove(director);
    }

    public void deleteAllDirector() {
        List<String> moviesList = new ArrayList<>();
        for (String director : DirectorMoviePair.keySet()) {
            for (String movie : DirectorMoviePair.get(director))
                moviesList.add(movie);
        }
        for (String movie : moviesList) {
            if (Moviemapping.containsKey(movie))
                Moviemapping.remove(movie);
        }
    }
}