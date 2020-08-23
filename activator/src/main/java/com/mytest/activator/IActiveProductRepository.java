package com.mytest.activator;

import com.mytest.activator.domain.ActiveProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActiveProductRepository extends JpaRepository<ActiveProduct, Integer> {
}
