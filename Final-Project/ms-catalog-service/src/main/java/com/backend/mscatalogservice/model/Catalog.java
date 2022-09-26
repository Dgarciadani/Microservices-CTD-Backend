package com.backend.mscatalogservice.model;

import com.backend.mscatalogservice.model.series.Series;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "catalogs")
public class Catalog {
    @Id
    private String id;

    private String genre;

    private Set<Movie> movies;

    private Set<Series> series;


    public void addSeriesAndMovies(List<Series> series, List<Movie> movies) {
        this.addMovie(movies);
        this.addSeries(series);
    }

    public void addSeries(List<Series> series) {
        this.series = Set.copyOf(series);
    }
    public void addMovie(List<Movie> movies) {
        this.movies = Set.copyOf(movies);
    }


}
