package com.backend.mscatalogservice.api.service;

import com.backend.mscatalogservice.model.Catalog;
import com.backend.mscatalogservice.model.Movie;
import com.backend.mscatalogservice.model.series.Series;

import java.util.List;

public interface ICatalogService {
    List<Movie> getMovieByGenre (String genre);

    List<Series> getSeriesByGenre (String genre);

    Catalog getCatalogByGenre (String genre);

    Catalog saveCatalog (Catalog catalog);

    void updateMovies (Catalog catalog,List<Movie> movies);

    void updateSeries (Catalog catalog,List<Series> series);
}
