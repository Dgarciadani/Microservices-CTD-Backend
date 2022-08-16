package com.grego.mssubscripcionservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="plans")
public class Plan {
    @Id
    private Long id;
    private String name;
    private Double price;
}
