package org.csystem.app.service.competition.dto;

public class AuthorSaveDTO {
    private String m_email;
    private String m_name;

    public String getEmail()
    {
        return m_email;
    }

    public void setEmail(String email)
    {
        m_email = email;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

}