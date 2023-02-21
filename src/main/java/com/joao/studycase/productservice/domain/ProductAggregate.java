package com.joao.studycase.productservice.domain;

import com.joao.studycase.productservice.command.CreateProductCommand;
import com.joao.studycase.productservice.core.events.ProductCreatedEvent;
import org.apache.logging.log4j.util.Strings;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price cannot be less or equal than zero.");
        }

        if (Strings.isBlank(createProductCommand.getTitle())) {
            throw new IllegalArgumentException("Product title cannot be empty.");
        }

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);

        AggregateLifecycle.apply(productCreatedEvent); //dispatch event to all available handlers in the aggregate
    }

}
