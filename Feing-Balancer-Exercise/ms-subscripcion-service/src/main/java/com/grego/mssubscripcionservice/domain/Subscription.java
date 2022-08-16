package com.grego.mssubscripcionservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "subscriptions")
public class Subscription {
    @Id
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private Plan plan;
    private Long userId;

}
