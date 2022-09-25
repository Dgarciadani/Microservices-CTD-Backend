package com.backend.mscatalogservice.model.series;

import java.util.List;

public record Series(String id, String name, String genre, List<Season> seasons) {
}

