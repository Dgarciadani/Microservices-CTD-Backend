package com.backend.msmovieservice.service.imp;

import com.backend.msmovieservice.domain.Movie;
import com.backend.msmovieservice.domain.dto.MovieReceivedDto;
import com.backend.msmovieservice.domain.dto.MovieToSendDto;
import com.backend.msmovieservice.repository.IMovieRepository;
import com.backend.msmovieservice.service.IMovieService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MovieService implements IMovieService {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MovieService.class);

    private final ModelMapper modelMapper;

    private final IMovieRepository movieRepository;


    @Override
    public MovieToSendDto save(MovieReceivedDto movieReceivedDto) {
        Movie movie = modelMapper.map(movieReceivedDto, Movie.class);
        movieRepository.save(movie);
        return modelMapper.map(movie, MovieToSendDto.class);
    }

    @Override
    public List<MovieToSendDto> getMovieByGenre(String genre) {
        List<Movie> movies = movieRepository.findByGenre(genre);
        return movies.stream().map(movie -> modelMapper.map(movie, MovieToSendDto.class)).toList();
    }

    @Override
    public MovieToSendDto registerMovie(MovieReceivedDto movieReceivedDto) {
        Movie movie = convertToMovie(movieReceivedDto);
        movieRepository.save(movie);
        return convertToMovieToSendDto(movie);
    }

    @Override
    public MovieToSendDto getMovieById(UUID id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        return convertToMovieToSendDto(movie);
    }


    //Mappers
    private Movie convertToMovie(MovieReceivedDto movieReceivedDto) {
        return modelMapper.map(movieReceivedDto, Movie.class);
    }

    private MovieToSendDto convertToMovieToSendDto(Movie movie) {
        return modelMapper.map(movie, MovieToSendDto.class);
    }

    private Movie convertToMovie(MovieToSendDto movieToSendDto) {
        return modelMapper.map(movieToSendDto, Movie.class);
    }

    private MovieToSendDto convertToMovieToSendDto(MovieReceivedDto movieReceivedDto) {
        return modelMapper.map(movieReceivedDto, MovieToSendDto.class);
    }
}

