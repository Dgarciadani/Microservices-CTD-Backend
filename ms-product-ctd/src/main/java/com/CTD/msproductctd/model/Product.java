package com.CTD.msproductctd.model;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "products")
public class Product {

    @Id
    private String idProduct;
    @Column
    @NotBlank
    private String name;
    @Column
    @NotNull
    private Double price;
    @Column
    @NotNull
    private LocalDateTime createdAt;



}
