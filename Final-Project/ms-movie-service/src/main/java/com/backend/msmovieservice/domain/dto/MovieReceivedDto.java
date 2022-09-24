package com.backend.msmovieservice.domain.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MovieReceivedDto {

    @NotNull(message = "Movie name is required")
    private String name;
    @NotNull(message = "Movie description is required")
    private String genre;
    @NotNull(message = "Movie description is required")
    private String urlStream;
}
