package com.joao.studycase.productservice.core.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {


    @Id
    @Column(unique = true)
    private String productId;

    @Column(unique = true)
    private String title;
    private BigDecimal price;
    private Integer quantity;

}
