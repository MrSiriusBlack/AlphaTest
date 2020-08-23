package com.mytest.app.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class ActiveProduct {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    private BigDecimal cost;
    private Boolean isActive;
}
