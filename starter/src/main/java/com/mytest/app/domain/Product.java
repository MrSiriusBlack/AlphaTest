package com.mytest.app.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    private String name;
    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;
}
