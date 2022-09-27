package com.backend.mscatalogservice.api.service;

import com.backend.mscatalogservice.api.client.IMovieService;

import com.backend.mscatalogservice.api.client.ISeriesService;
import com.backend.mscatalogservice.api.repository.ICatalogRepository;
import com.backend.mscatalogservice.model.Catalog;
import com.backend.mscatalogservice.model.Movie;
import com.backend.mscatalogservice.model.series.Series;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class CatalogService implements ICatalogService {

    private final IMovieService movieService;

    private final ISeriesService seriesService;

    private final ICatalogRepository repository;

    @Override
    public List<Movie> getMovieByGenre(String genre) {
        ResponseEntity<List<Movie>> response = movieService.getMovieByGenre(genre);
        Catalog catalog = this.getCatalogByGenre(genre);
        if (catalog == null) {
            catalog = new Catalog();
            catalog.setGenre(genre);
            catalog.addMovies(response.getBody());
            this.saveCatalog(catalog);
        } else {
            this.updateMovies(catalog, response.getBody());
        }
        return response.getBody();
    }

    @Override
    public List<Series> getSeriesByGenre(String genre) {
        ResponseEntity<List<Series>> response = seriesService.getSeriesByGenre(genre);
        Catalog catalog = this.getCatalogByGenre(genre);
        if (catalog == null) {
            catalog = new Catalog();
            catalog.setGenre(genre);
            catalog.addSeries(response.getBody());
            this.saveCatalog(catalog);
        } else {
            this.updateSeries(catalog, response.getBody());
        }
        return response.getBody();
    }

    @Override
    public Catalog getCatalogByGenre(String genre) {
        Catalog catalog = repository.findByGenre(genre);
        if (catalog != null) {
            if (catalog.getMovies() == null) {
                updateMovies(catalog, movieService.getMovieByGenre(genre).getBody());
            }
            if (catalog.getSeries() == null) {
                updateSeries(catalog, seriesService.getSeriesByGenre(genre).getBody());
            }
            return catalog;
        } else {
            Catalog newCatalog = new Catalog();
            newCatalog.setGenre(genre);
            newCatalog.addMovies(movieService.getMovieByGenre(genre).getBody());
            newCatalog.addSeries(seriesService.getSeriesByGenre(genre).getBody());
            return this.saveCatalog(newCatalog);
        }
    }

    @Override
    public Catalog saveCatalog(Catalog catalog) {
        return repository.save(catalog);
    }

    @Override
    public void updateMovies(Catalog catalog, List<Movie> movies) {
        catalog.setMovies(Set.copyOf(movies));
        repository.save(catalog);
    }

    @Override
    public void updateSeries(Catalog catalog, List<Series> series) {
        catalog.setSeries(Set.copyOf(series));
        repository.save(catalog);
    }

    @Override

    public void addMovie(String genre,Movie movie) {
        Catalog catalog = this.getCatalogByGenre(genre);
        catalog.addAMovie(movie);
        repository.save(catalog);
    }

    @Override
    public void addSeries(String genre,Series series) {
        Catalog catalog = this.getCatalogByGenre(genre);
        catalog.addASeries(series);
        repository.save(catalog);
    }

}
