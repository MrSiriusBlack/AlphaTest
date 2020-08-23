package com.mytest.app;

import com.mytest.app.domain.ActiveProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IActiveProductRepository extends JpaRepository<ActiveProduct, Integer> {

    Optional<ActiveProduct> getActiveProductByClientIdAndProductNameAndIsActiveOrderByIdDesc(int clientId, String productName, Boolean isActive);

    @Query("select ap.client.id as id, ap.client.name as name, count(ap.product) as num from ActiveProduct ap where ap.product.name like :productName group by ap.client.id, ap.client.name")
    List<ProductPurchaseCount> getPurchaseList(@Param("productName") String productName);
}
