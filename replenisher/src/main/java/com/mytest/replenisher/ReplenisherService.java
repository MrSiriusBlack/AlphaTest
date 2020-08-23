package com.mytest.replenisher;

import com.mytest.replenisher.domain.Client;
import com.mytest.replenisher.domain.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ReplenisherService {

    private final IClientRepository clientRepository;
    private final IProviderRepository providerRepository;

    public void replenishClientBalance(int clientId, BigDecimal sum) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        client.setBalance(client.getBalance().add(sum));
        clientRepository.save(client);
    }

    public void replenishProviderBalance(int providerId, BigDecimal sum) {
        Provider provider = providerRepository.findById(providerId).orElseThrow();
        provider.setBalance(provider.getBalance().add(sum));
        providerRepository.save(provider);
    }
}
