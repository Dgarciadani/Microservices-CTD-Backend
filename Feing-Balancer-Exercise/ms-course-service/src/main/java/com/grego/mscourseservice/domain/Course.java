package com.grego.mscourseservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "courses")
public class Course {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "course")
    private List<Chapter> chapters;
}
