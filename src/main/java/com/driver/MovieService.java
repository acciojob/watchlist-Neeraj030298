package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movierepository;

    public void addmovie(Movie movie)
    {
        movierepository.addMovie(movie);
    }

    public void adddirector(Director director)
    {
        movierepository.addDirector(director);
    }

    public void createMovieDirectorPair(String movie, String director)
    {
        movierepository.saveDirectorMoviePair(movie, director);
    }
    public void findmovie(String movie)
    {
        movierepository.findMovie(movie);
    }
    public void finddirector(String director)
    {
        movierepository.findDirector(director);
    }

    public void findmoviefromdirector(String director)
    {
        movierepository.findMovieFromDirector(director);
    }

    public void findallmovie()
    {
        movierepository.findAllMovie();
    }
    public void deletedirector(String director)
    {
        movierepository.deleteDirector(director);
    }

    public void deletealldirector()
    {
        movierepository.deleteAllDirector();
    }

}
