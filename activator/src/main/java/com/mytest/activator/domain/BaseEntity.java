package com.mytest.activator.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity<IdT extends Serializable> implements IEntity<IdT> {

    @Id
    @GeneratedValue(generator = "Sequence")
    private IdT id;

    @Override
    public IdT getId() {
        return id;
    }

    @Override
    public void setId(IdT id) {

    }
}