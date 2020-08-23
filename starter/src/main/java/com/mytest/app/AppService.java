package com.mytest.app;

import com.mytest.app.domain.Product;
import com.mytest.app.domain.Provider;
import com.mytest.app.domain.ActiveProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppService {

    private final IProductRepository productRepository;
    private final IActiveProductRepository activeProductRepository;

    /**
     * Возвращает провайдера услуги
     *
     * @param productName Название услуги
     */
    public Provider getProviderByProductName(String productName) {
        Product product = productRepository.findById(productName).orElseThrow();
        return product.getProvider();
    }

    /**
     * Возвращает последнюю купленную клиентом активную услугу
     *
     * @param clientId Идентификатор клиента
     * @param product  Название услуги
     */
    public ActiveProduct getActiveClientProduct(int clientId, String product) {
        return activeProductRepository
                .getActiveProductByClientIdAndProductNameAndIsActiveOrderByIdDesc(clientId, product, true).orElseThrow();
    }

    public List<ProductPurchaseCount> getProductSaleList(String productName) {
        return activeProductRepository.getPurchaseList(productName);
    }
}
