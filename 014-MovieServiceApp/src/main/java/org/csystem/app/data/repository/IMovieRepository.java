package org.csystem.app.data.repository;

import org.csystem.app.data.entity.Movie;
import org.csystem.util.data.repository.ICrudRepository;

import java.time.LocalDate;

public interface IMovieRepository extends ICrudRepository<Movie, Long> {

    Iterable<Movie> findByMonth(int month);
    Iterable<Movie> findByYear(int year);
    Iterable<Movie> findByMonthAndYear(int month, int year);
    Iterable<Movie> findByDateBetween(LocalDate begin, LocalDate end);
    Iterable<Movie> findByYearBetween(int begin, int end);
    Iterable<Movie> findByDirectorId(long directorId);

}
