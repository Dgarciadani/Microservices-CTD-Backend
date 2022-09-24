package com.backend.msmovieservice.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "movies")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Movie {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @NotNull(message = "Movie name is required")
    private String name;
    @NotNull(message = "Movie description is required")
    private String genre;
    @NotNull(message = "Movie description is required")
    private String urlStream;

}
