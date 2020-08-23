package com.mytest.app.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

@Entity
@Data
@SequenceGenerator(name = "Sequence", sequenceName = "provider_id_seq", allocationSize = 1)
public class Provider extends BaseEntity<Integer> {

    private String name;
    private BigDecimal balance;
}
