package org.csystem.app.mapper;

import org.csystem.app.data.entity.Movie;
import org.csystem.app.mapper.dto.MovieDTO;
import org.csystem.app.mapper.dto.MoviesDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MovieMapperImpl", componentModel = "spring")
public interface IMovieMapper {
    MovieDTO toMovieDTO(Movie movie);

    default MoviesDTO toMoviesDTO(List<MovieDTO> movieDTOS)
    {
        var dto = new MoviesDTO();

        dto.setMovies(movieDTOS);

        return dto;
    }
}