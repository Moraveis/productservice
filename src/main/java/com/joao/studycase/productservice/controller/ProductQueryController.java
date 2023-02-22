package com.joao.studycase.productservice.controller;

import com.joao.studycase.productservice.query.FindProductQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    private final QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProductResponse> findAllProducts() {
        FindProductQuery findProductQuery = new FindProductQuery();
        List<ProductResponse> products = queryGateway.query(findProductQuery, ResponseTypes.multipleInstancesOf(ProductResponse.class)).join();
        return products;
    }
}
