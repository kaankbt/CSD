package org.csystem.app.service;

import org.csystem.app.data.dal.MovieServiceAppHelper;
import org.csystem.app.mapper.dto.MoviesDTO;
import org.csystem.app.mapper.IMovieMapper;
import org.springframework.stereotype.Service;
import static org.csystem.util.collection.CollectionUtil.toList;

@Service
public class MovieAppService {
    private final MovieServiceAppHelper m_movieServiceAppHelper;
    private final IMovieMapper m_movieMapper;


    public MovieAppService(MovieServiceAppHelper movieServiceAppHelper, IMovieMapper movieMapper)
    {
        m_movieServiceAppHelper = movieServiceAppHelper;
        m_movieMapper = movieMapper;
    }

    public long movieCount()
    {
        return m_movieServiceAppHelper.movieCount();
    }

    public MoviesDTO findMoviesByMonth(int month)
    {
        return m_movieMapper.toMoviesDTO(toList(m_movieServiceAppHelper.findMoviesByMonth(month), m_movieMapper::toMovieDTO));
    }

    public MoviesDTO findMoviesByYear(int year)
    {
        return m_movieMapper.toMoviesDTO(toList(m_movieServiceAppHelper.findMoviesByYear(year), m_movieMapper::toMovieDTO));
    }

    public MoviesDTO findMoviesByMonthAndYear(int month, int year)
    {
        return m_movieMapper.toMoviesDTO(toList(m_movieServiceAppHelper.findMoviesByMonthAndYear(month, year),
                m_movieMapper::toMovieDTO));
    }

    public MoviesDTO findMoviesByYearBetween(int begin, int end)
    {
        return m_movieMapper.toMoviesDTO(toList(m_movieServiceAppHelper.findMoviesByYearBetween(begin, end),
                m_movieMapper::toMovieDTO));
    }

    //...
}