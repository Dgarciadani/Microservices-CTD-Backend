package com.backend.msserieservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Document(collection = "seasons")
public class Season implements Serializable {
    @Id
    private String id;
    private Integer seasonNumber;
    @JsonIgnore
    private String seriesId;
    @Transient
    private List<Chapter> chapters;

    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }

}
