package com.mytest.activator;

import com.mytest.activator.domain.ActiveProduct;
import com.mytest.activator.domain.Client;
import com.mytest.activator.domain.Product;
import com.mytest.activator.dto.CancelRequest;
import com.mytest.activator.dto.SellRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivatorService {

    private final IActiveProductRepository activeProductRepository;
    private final IClientRepository clientRepository;
    private final IProductRepository productRepository;

    public void sell(SellRequest sellRequest) {
        Product product = productRepository.findById(sellRequest.getProduct()).orElseThrow();
        Client client = clientRepository.findById(sellRequest.getClient()).orElseThrow();
        ActiveProduct activeProduct = new ActiveProduct(product, client, sellRequest.getSum(), true);
        activeProductRepository.save(activeProduct);
    }

    public void deactivate(CancelRequest cancelRequest) {
        ActiveProduct activeProduct = activeProductRepository.findById(cancelRequest.getActiveProductId()).orElseThrow();
        activeProduct.setIsActive(false);
        activeProductRepository.save(activeProduct);
    }
}
