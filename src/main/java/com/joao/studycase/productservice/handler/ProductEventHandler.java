package com.joao.studycase.productservice.handler;

import com.joao.studycase.productservice.core.entity.ProductEntity;
import com.joao.studycase.productservice.core.events.ProductCreatedEvent;
import com.joao.studycase.productservice.core.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class ProductEventHandler {

    private final ProductRepository productRepository;

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ExceptionHandler()
    public void handler(Exception ex) throws Exception {
        throw ex;
    }

    @ExceptionHandler(resultType = IllegalArgumentException.class)
    public void handler(IllegalArgumentException ex) {

    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);

        try {
            productRepository.save(productEntity);
        } catch (IllegalArgumentException ex) {
            ex.getStackTrace();
        }
    }
}
