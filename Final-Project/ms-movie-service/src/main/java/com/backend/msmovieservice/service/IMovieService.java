package com.backend.msmovieservice.service;

import com.backend.msmovieservice.domain.dto.MovieReceivedDto;
import com.backend.msmovieservice.domain.dto.MovieToSendDto;

import java.util.List;
import java.util.UUID;

public interface IMovieService {

    public MovieToSendDto save(MovieReceivedDto movieReceivedDto);

    public List<MovieToSendDto> getMovieByGenre(String genre);

    public MovieToSendDto registerMovie(MovieReceivedDto movieReceivedDto);

    public MovieToSendDto getMovieById(UUID id);




}
