package com.joao.studycase.productservice.handler;

import com.joao.studycase.productservice.core.entity.ProductLookupEntity;
import com.joao.studycase.productservice.core.events.ProductCreatedEvent;
import com.joao.studycase.productservice.core.repository.ProductLookupRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup(value = "product-group")
public class ProductLookupEventHandler {

    private final ProductLookupRepository productLookupRepository;

    public ProductLookupEventHandler(ProductLookupRepository productLookupRepository) {
        this.productLookupRepository = productLookupRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductLookupEntity entity = new ProductLookupEntity(event.getProductId(), event.getTitle());
        productLookupRepository.save(entity);
    }
}
