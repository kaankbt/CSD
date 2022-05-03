package org.csystem.app.mapper.dto;

import java.util.List;

public class MoviesDTO {
    private List<MovieDTO> m_movies;

    public List<MovieDTO> getMovies()
    {
        return m_movies;
    }

    public void setMovies(List<MovieDTO> movies)
    {
        m_movies = movies;
    }
}