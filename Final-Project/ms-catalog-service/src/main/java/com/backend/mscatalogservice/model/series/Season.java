package com.backend.mscatalogservice.model.series;

import java.util.List;

public record Season(String id, Integer seasonNumber, List<Chapter> chapters) {
}

