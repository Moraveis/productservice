package com.joao.studycase.productservice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public String getProduct() {
        return "HTTP GET Request handled";
    }

    @PostMapping
    public String createProduct() {
        return "HTTP POST Request handled";
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
