package com.backend.msmovieservice.service.imp;

import com.backend.msmovieservice.domain.Movie;
import com.backend.msmovieservice.domain.dto.MovieReceivedDto;
import com.backend.msmovieservice.domain.dto.MovieToSendDto;
import com.backend.msmovieservice.service.IMovieService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class MovieService implements IMovieService {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MovieService.class);

    private final ModelMapper modelMapper;

    private final IMovieService movieService;



    @Override
    public MovieToSendDto getMovieByGenre(String genre) {
        
    }

    @Override
    public MovieToSendDto registerMovie(MovieReceivedDto movieReceivedDto) {
        return null;
    }

    @Override
    public MovieToSendDto getMovieById(UUID id) {
        return null;
    }


    //Mappers
    private Movie convertToMovie(MovieReceivedDto movieReceivedDto){
        return modelMapper.map(movieReceivedDto, Movie.class);
    }
    private MovieToSendDto convertToMovieToSendDto(Movie movie){
        return modelMapper.map(movie, MovieToSendDto.class);
    }
    private Movie convertToMovie(MovieToSendDto movieToSendDto){
        return modelMapper.map(movieToSendDto, Movie.class);
    }
    private MovieToSendDto convertToMovieToSendDto(MovieReceivedDto movieReceivedDto){
        return modelMapper.map(movieReceivedDto, MovieToSendDto.class);
    }
}

