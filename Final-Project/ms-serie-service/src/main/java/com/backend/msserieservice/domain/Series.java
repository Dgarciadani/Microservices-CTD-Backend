package com.backend.msserieservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "series")
public class Series implements Serializable {
    @Id
    private String id;
    private String name;
    private String genre;


    @Transient
    private List<Season> seasons;


}
