package com.mytest.reducer;

import com.mytest.reducer.domain.Client;
import com.mytest.reducer.domain.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ReducerService {

    private final IClientRepository clientRepository;
    private final IProviderRepository providerRepository;

    public void reduceClientBalance(int clientId, BigDecimal sum) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        client.setBalance(client.getBalance().subtract(sum));
        clientRepository.save(client);
    }

    public void reduceProviderBalance(int providerId, BigDecimal sum) {
        Provider provider = providerRepository.findById(providerId).orElseThrow();
        provider.setBalance(provider.getBalance().subtract(sum));
        providerRepository.save(provider);
    }
}
