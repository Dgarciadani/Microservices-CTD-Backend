package com.backend.msserieservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "chapters")
public class Chapter implements Serializable {
    @Id
    private String id;
    private String name;
    private Integer chapterNumber;
    private String urlStream;
    @JsonIgnore
    private String seasonId;
}
