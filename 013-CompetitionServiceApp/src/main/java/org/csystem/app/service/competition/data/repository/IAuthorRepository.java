package org.csystem.app.service.competition.data.repository;

import org.csystem.util.data.repository.*;
import org.csystem.app.service.competition.data.entity.Author;

public interface IAuthorRepository extends ICrudRepository<Author, String> {
    Iterable<Author> findByName(String name);

    Iterable<Author> findByNameContains(String text);

    Iterable<Author> findByMonthBetween(int min, int max);

    Iterable<Author> findByYearBetween(int min, int max);

    Iterable<Author> findByMonthAndYear(int month, int year);
}
