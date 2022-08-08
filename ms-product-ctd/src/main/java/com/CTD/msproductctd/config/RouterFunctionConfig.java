package com.CTD.msproductctd.config;

import com.CTD.msproductctd.config.handlers.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.servlet.function.RouterFunction;

@Configuration
public class RouterFunctionConfig {
    private static final String PRODUCT_PATH = "api/v1/product";

    private static final String PRODUCT_ID_PATH = "api/v1/product/{id}";

    @Bean
    public RouterFunction<ServerResponse> routers(ProductHandler handler){
        return null;
    }

}

