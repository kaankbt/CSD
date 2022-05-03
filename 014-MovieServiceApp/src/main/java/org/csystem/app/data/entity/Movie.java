package org.csystem.app.data.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movie {
    private long m_id;
    private String m_name;
    private LocalDate m_scaneDate;
    private long m_rating;
    private BigDecimal m_cost;
    private double m_imdb;

    public Movie(long id, String name, LocalDate scaneDate, long rating, BigDecimal cost, double imdb) {
        this.m_id = id;
        this.m_name = name;
        this.m_scaneDate = scaneDate;
        this.m_rating = rating;
        this.m_cost = cost;
        this.m_imdb = imdb;
    }

    public long getId() {
        return m_id;
    }

    public void setId(long id) {
        m_id = id;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        m_name = name;
    }

    public LocalDate getScaneDate() {
        return m_scaneDate;
    }

    public void setScaneDate(LocalDate scaneDate) {
        m_scaneDate = scaneDate;
    }

    public long getRating() {
        return m_rating;
    }

    public void setRating(long rating) {
        m_rating = rating;
    }

    public BigDecimal getCost() {
        return m_cost;
    }

    public void setCost(BigDecimal cost) {
        m_cost = cost;
    }

    public double getImdb() {
        return m_imdb;
    }

    public void setImdb(double imdb) {
        m_imdb = imdb;
    }
}
