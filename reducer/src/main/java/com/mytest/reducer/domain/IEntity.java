package com.mytest.reducer.domain;

import java.io.Serializable;

public interface IEntity<IdT extends Serializable> {

    IdT getId();

    void setId(IdT id);
}
