package com.mytest.activator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@SequenceGenerator(name = "Sequence", sequenceName = "active_product_id_seq", allocationSize = 1)
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class ActiveProduct extends BaseEntity<Integer> {

    @ManyToOne
    @JoinColumn(name = "product", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    private BigDecimal cost;
    private Boolean isActive;
}
