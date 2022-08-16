package com.grego.mscourseservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "chapters")
public class Chapter {
    @Id
    private Long id;
    private String name;
    private String urlStreaming;
    @ManyToOne
    @JsonIgnore
    private Course course;

}
