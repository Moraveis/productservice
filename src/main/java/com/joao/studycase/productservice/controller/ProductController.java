package com.joao.studycase.productservice.controller;

import com.joao.studycase.productservice.command.CreateProductCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private Environment env;

    @GetMapping
    public String getProduct() {
        return "HTTP GET Request handled" + env.getProperty("local.server.port");
    }

    @PostMapping
    public String createProduct(@RequestBody ProductRequest request) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .title(request.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();

        return "HTTP POST Request handled. Product = " + request.getTitle();
    }

    @PutMapping
    public String updateProduct() {
        return "HTTP PUT Request handled";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "HTTP DELETE Request handled";
    }
}
