package com.backend.mscatalogservice.model.series;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public record Series(String id, String name, String genre, List<Season> seasons) {
}

