package com.CTD.msproductctd.service;

import com.CTD.msproductctd.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {

    Flux<Product> findAllProducts();

    Mono<Product> findProductById(String id);

    Mono<Product> saveProduct(Product product);
    Mono<Product> updateProduct(Product product);

    Mono<Void> deleteProduct(Product product);

}
