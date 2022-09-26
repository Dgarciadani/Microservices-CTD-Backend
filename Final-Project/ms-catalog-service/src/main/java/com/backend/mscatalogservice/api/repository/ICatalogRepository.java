package com.backend.mscatalogservice.api.repository;

import com.backend.mscatalogservice.model.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ICatalogRepository extends MongoRepository<Catalog,String> {

    Catalog findByGenre(String genre);


}
