package org.csystem.app.data.repository;

import org.csystem.app.data.entity.Movie;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository implements IMovieRepository {

    private static final String COUNT_SQL = "select count(*) from movies";
    private static final String FIND_BY_MONTH_SQL = "select * from movies where date_part('month', scene_date) = :month";
    private static final String FIND_BY_YEAR_SQL = "select * from movies where date_part('year', scene_date) = :year";

    // JAVA 17 TEXT
    private static final String FIND_BY_MONTH_YEAR_SQL = """
                            select * from movies 
                            where   
                            date_part('month', scene_date) = :month and date_part('year', scene_date) = :year
                            """;
    private static final String FIND_BY_YEAR_BETWEEN_SQL = "select * from movies where date_part('year', scene_date) between :begin and :end";
    private static final String FIND_BY_DATE_BETWEEN_SQL = "select * from movies where scene_date between :begin and :end";

    //Bu sorgunun fonksiyon yapılması daha iyi bir tekniktir. Durumu göstermek için fonksiyon yapılmamıştır
    private static final String FIND_BY_DIRECTOR_ID = """
                            select m.movie_id, m.name, m.scene_date, m.rating, m.cost, m.imdb
                            from movies m inner join movies_to_director mtd on m.movie_id = mtd.movie_id
                            where mtd.director_id = :director_id
                            """;
    private static final String SAVE_SQL = "insert into movies (name, scene_date, cost) values (:name, :sceneDate, :cost)";

//____________________________________________________________________________________________________
    // Template Ctor Injection

    private final NamedParameterJdbcTemplate m_jdbcTemplate;

    public MovieRepository(NamedParameterJdbcTemplate jdbcTemplate)
    {
        m_jdbcTemplate = jdbcTemplate;
    }


//____________________________________________________________________________________________________
    // Liste doldurma
    private static void fillMovies(ResultSet rs, List<Movie> movies) throws SQLException {
        do {
            var id = rs.getLong(1);
            var name = rs.getString(2);
            var sceneDate = rs.getDate(3).toLocalDate();
            var rating = rs.getLong(4);
            var cost = BigDecimal.valueOf(rs.getDouble(5));
            var imdb = rs.getDouble(6);
            movies.add(new Movie(id,name,sceneDate,rating,cost,imdb));

        }while (rs.next());

    }
//____________________________________________________________________________________________________


    @Override
    public Iterable<Movie> findByMonth(int month) {
        var paramMap = new HashMap<String, Object>();

        paramMap.put("month", month);
        var movies = new ArrayList<Movie>();

        m_jdbcTemplate.query(FIND_BY_MONTH_SQL, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;    }

    @Override
    public Iterable<Movie> findByYear(int year) {
        var paramMap = new HashMap<String, Object>();

        paramMap.put("year", year);
        var movies = new ArrayList<Movie>();

        m_jdbcTemplate.query(FIND_BY_YEAR_SQL, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> findByMonthAndYear(int month, int year) {
        var paramMap = new HashMap<String, Object>();

        paramMap.put("month", month);
        paramMap.put("year", year);
        var movies = new ArrayList<Movie>();

        m_jdbcTemplate.query(FIND_BY_MONTH_YEAR_SQL, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> findByYearBetween(int begin, int end) {
        var paramMap = new HashMap<String, Object>();

        paramMap.put("begin", begin);
        paramMap.put("end", end);
        var movies = new ArrayList<Movie>();

        m_jdbcTemplate.query(FIND_BY_YEAR_BETWEEN_SQL, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> findByDateBetween(LocalDate begin, LocalDate end) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findByDirectorId(long directorId) {
        var paramMap = new HashMap<String, Object>();

        paramMap.put("director_id", directorId);
        var movies = new ArrayList<Movie>();

        m_jdbcTemplate.query(FIND_BY_DIRECTOR_ID, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public long count() {
        var counts = new ArrayList<Long>();

        m_jdbcTemplate.query(COUNT_SQL, (ResultSet rs) -> {counts.add(rs.getLong(1));});

        return counts.get(0);
    }


@Override
public <S extends Movie> S save(S movie){
    var keyHolder = new GeneratedKeyHolder();
    var parameterSource = new BeanPropertySqlParameterSource(movie);

    parameterSource.registerSqlType("sceneDate", Types.DATE);
    parameterSource.registerSqlType("cost", Types.DECIMAL);

    m_jdbcTemplate.update(SAVE_SQL, parameterSource, keyHolder, new String[] {"movie_id"});

    movie.setId(keyHolder.getKey().longValue());

    return movie;
}

//____________________________________________________________________________________________________

    @Override
    public void delete(Movie movie) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteAll(Iterable<? extends Movie> movies) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        throw new UnsupportedOperationException();
    }




    @Override
    public <S extends Movie> Iterable<S> save(Iterable<S> entities) {
        return null;
    }
}
