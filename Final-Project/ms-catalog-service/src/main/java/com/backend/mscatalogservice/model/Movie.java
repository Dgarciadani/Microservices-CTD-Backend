package com.backend.mscatalogservice.model;

import java.util.UUID;

public record Movie(UUID id, String name, String genre, String urlStream) {
}
