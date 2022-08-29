package com.example.playlistservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Musica {

	private Long id;

	private String name;

	private String genre;

	private String urlStream;
}
