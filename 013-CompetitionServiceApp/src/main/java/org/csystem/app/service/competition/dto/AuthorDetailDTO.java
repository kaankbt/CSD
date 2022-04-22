package org.csystem.app.service.competition.dto;

import java.time.LocalDate;

public class AuthorDetailDTO {
    private String m_email;
    private String m_name;
    private LocalDate m_registerDate;

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String email) {
        this.m_email = email;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String name) {
        this.m_name = name;
    }

    public LocalDate getRegisterTime() {
        return m_registerDate;
    }

    public void setRegisterTime(LocalDate registerTime) {
        this.m_registerDate = registerTime;
    }
}
