package com.CTD.msproductctd.service.imp;

import com.CTD.msproductctd.model.Product;
import com.CTD.msproductctd.repository.ProductRepository;
import com.CTD.msproductctd.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
//Esta es la forma de inyectar dependencias en un constructor, es mejor que la de la anotacion @Autowired
public class ProductService implements IProductService {

    //Aca se inyecta el repositorio para poder hacer las operaciones CRUD
    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Flux<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Product> findProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Void> deleteProduct(Product Product) {
        return productRepository.delete(Product);
    }
}
