package com.backend.mscatalogservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


public record Movie(UUID id, String name, String genre, String urlStream) {

}
