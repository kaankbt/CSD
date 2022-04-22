package org.csystem.app.service.competition.mapper;

import org.csystem.app.service.competition.data.entity.Author;
import org.csystem.app.service.competition.dto.AuthorDTO;
import org.csystem.app.service.competition.dto.AuthorDetailDTO;
import org.csystem.app.service.competition.dto.AuthorSaveDTO;
import org.csystem.app.service.competition.dto.AuthorsDetailDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(implementationName = "AuthorMapperImpl", componentModel = "spring")
public interface IAuthorMapper {
    AuthorDetailDTO toAuthorDetailDTO(Author author);
    AuthorDTO toAuthorDTO(Author author);
    Author toAuthor(AuthorSaveDTO authorSaveDTO);
    default AuthorsDetailDTO toAuthorsDetailDTO(List<AuthorDetailDTO> authors)
    {
        var result = new AuthorsDetailDTO();

        result.setAuthors(authors);

        return result;
    }
}