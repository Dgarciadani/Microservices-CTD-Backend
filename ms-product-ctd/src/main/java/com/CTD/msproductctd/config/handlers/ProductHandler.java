package com.CTD.msproductctd.config.handlers;

import com.CTD.msproductctd.model.Product;
import com.CTD.msproductctd.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.net.URI;
import java.time.LocalDateTime;


@Component
@RequiredArgsConstructor //  inyecta las dependencias en el constructor
public class ProductHandler {

    private final IProductService productService;
    private final Validator validator;

    private String path;

    public Mono<ServerResponse> list(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productService.findAllProducts(), Product.class).switchIfEmpty(ServerResponse.noContent().build());
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productService.findProductById(id), Product.class).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        Mono<Product> product = serverRequest.bodyToMono(Product.class);

        return product.flatMap(productService::saveProduct)
                .flatMap(p -> {
                    Errors errors = new BeanPropertyBindingResult(p, Product.class.getName());
                    validator.validate(p, errors);
                    if (errors.hasErrors()) {
                        return Flux.fromIterable(errors.getFieldErrors())
                                .map(fe -> String.format("%s: %s", fe.getField(), fe.getDefaultMessage()))
                                .collectList()
                                .flatMap(messages -> ServerResponse.badRequest().body(Mono.just(messages), String.class));
                    } else {
                        if (p.getCreatedAt() == null) {
                            p.setCreatedAt(LocalDateTime.now());
                        }
                        return productService.saveProduct(p).flatMap(p1 -> ServerResponse.created(URI.create("/api/v1/products/".concat(p1.getIdProduct()))).body(Mono.just(p1), Product.class));
                    }
                });
    }

    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<Product> product = serverRequest.bodyToMono(Product.class);
        Mono<Product> productDB = productService.findProductById(id);
        return productDB.zipWith(product, (pdb, req) -> {
                    pdb.setName(req.getName());
                    pdb.setPrice(req.getPrice());
                    return pdb;
                }).flatMap(productService::updateProduct)
                .flatMap(p -> {
                    Errors errors = new BeanPropertyBindingResult(p, Product.class.getName());
                    validator.validate(p, errors);
                    if (errors.hasErrors()) {
                        return Flux.fromIterable(errors.getFieldErrors())
                                .map(fe -> String.format("%s: %s", fe.getField(), fe.getDefaultMessage()))
                                .collectList()
                                .flatMap(messages -> ServerResponse.badRequest().body(Mono.just(messages), String.class));
                    } else {
                        return productService.updateProduct(p).flatMap(p1 -> ServerResponse.ok().body(Mono.just(p1), Product.class));
                    }
                });
    }

}
