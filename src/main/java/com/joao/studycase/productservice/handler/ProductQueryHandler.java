package com.joao.studycase.productservice.handler;

import com.joao.studycase.productservice.controller.ProductResponse;
import com.joao.studycase.productservice.core.entity.ProductEntity;
import com.joao.studycase.productservice.core.repository.ProductRepository;
import com.joao.studycase.productservice.query.FindProductQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductQueryHandler {

    private final ProductRepository productRepository;

    public ProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductResponse> findAllProducts(FindProductQuery findProductQuery) {
        return productRepository.findAll().stream().map(this::fromProductEntity).collect(Collectors.toList());
    }

    private ProductResponse fromProductEntity(ProductEntity entity) {
        ProductResponse response = new ProductResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

}
