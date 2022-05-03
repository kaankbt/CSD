package org.csystem.app.mapper;

import javax.annotation.processing.Generated;
import org.csystem.app.data.entity.Movie;
import org.csystem.app.mapper.dto.MovieDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-03T19:24:57+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class MovieMapperImpl implements IMovieMapper {

    @Override
    public MovieDTO toMovieDTO(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setName( movie.getName() );
        movieDTO.setCost( movie.getCost() );
        movieDTO.setRating( movie.getRating() );

        return movieDTO;
    }
}
