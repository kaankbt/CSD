package org.csystem.app.data.dal;

import org.csystem.app.data.entity.Movie;
import org.csystem.app.data.repository.IMovieRepository;
import org.csystem.app.data.repository.MovieRepository;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceAppHelper {

    private IMovieRepository m_movieRepository;

    public MovieServiceAppHelper(MovieRepository movieRepository) {
        m_movieRepository = movieRepository;
    }

    //Movie
    public long movieCount()
    {
        return m_movieRepository.count();
    }
    public Iterable<Movie> findMoviesByMonth(int month)
    {
        return m_movieRepository.findByMonth(month);
    }
    public Iterable<Movie> findMoviesByYear(int year)
    {
        return m_movieRepository.findByYear(year);
    }
    public Iterable<Movie> findMoviesByMonthAndYear(int month, int year)
    {
        return m_movieRepository.findByMonthAndYear(month, year);
    }

    public Iterable<Movie> findMoviesByYearBetween(int begin, int end)
    {
        return m_movieRepository.findByYearBetween(begin, end);
    }

    public  Movie saveMovie(Movie movie)
    {
        return m_movieRepository.save(movie);
    }
}
