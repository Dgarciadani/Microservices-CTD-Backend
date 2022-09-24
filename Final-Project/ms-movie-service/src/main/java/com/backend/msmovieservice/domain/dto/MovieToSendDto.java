package com.backend.msmovieservice.domain.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MovieToSendDto {

    private UUID id;
    private String name;
    private String genre;
    private String urlStream;
}
