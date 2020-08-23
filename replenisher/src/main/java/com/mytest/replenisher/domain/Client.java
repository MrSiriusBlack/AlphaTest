package com.mytest.replenisher.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

@Entity
@Data
@SequenceGenerator(name = "Sequence", sequenceName = "client_id_seq", allocationSize = 1)
@DynamicUpdate
public class Client extends BaseEntity<Integer> {

    private String name;
    private BigDecimal balance;
}
