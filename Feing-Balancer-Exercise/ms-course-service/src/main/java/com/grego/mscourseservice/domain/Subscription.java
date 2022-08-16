package com.grego.mscourseservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subscription {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long planId;
    private Long userId;

}
