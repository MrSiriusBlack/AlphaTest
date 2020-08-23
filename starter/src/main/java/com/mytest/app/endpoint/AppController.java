package com.mytest.app.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mytest.app.AppService;
import com.mytest.app.ProductPurchaseCount;
import com.mytest.app.domain.ActiveProduct;
import com.mytest.app.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "Контроллер главного сервиса")
@RestController
@RequiredArgsConstructor
public class AppController {
    private final String HTTP = "http://";
    private final String HOST_URL = "localhost:";
    private final String ACTIVATOR_URL = "/activator";
    private final String REDUCER_URL = "/reducer";
    private final String REPLENISHER_URL = "/replenisher";
    private final String ACTIVATOR_PORT = "8081";
    private final String REDUCER_PORT = "8082";
    private final String REPLENISHER_PORT = "8083";

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final AppService appService;

    @ApiOperation("Оплата услуги/продукта")
    @PostMapping("/pay")
    public void payment(@RequestBody PaymentRequest paymentRequest) throws JsonProcessingException {
        BalanceRequest balanceRequest = new BalanceRequest(null, null, paymentRequest.getSum());
        balanceRequest.setClient(paymentRequest.getClient());
        String uri = HTTP + HOST_URL + REDUCER_PORT + REDUCER_URL;
        ObjectMapper objectMapper = new ObjectMapper();
        postRequest(uri, objectMapper.writeValueAsString(balanceRequest));
        uri = HTTP + HOST_URL + REPLENISHER_PORT + REPLENISHER_URL;
        balanceRequest.setClient(null);
        balanceRequest.setProvider(appService.getProviderByProductName(paymentRequest.getProduct()).getId());
        postRequest(uri, objectMapper.writeValueAsString(balanceRequest));
        uri = HTTP + HOST_URL + ACTIVATOR_PORT + ACTIVATOR_URL + "/sell";
        postRequest(uri, objectMapper.writeValueAsString(paymentRequest));
    }

    @ApiOperation("Отмена услуги/продукта")
    @PostMapping("/cancel")
    public void cancel(@RequestBody CancelRequest cancelRequest) throws JsonProcessingException {
        ActiveProduct activeProduct = appService.getActiveClientProduct(cancelRequest.getClient(),cancelRequest.getProduct());
        BalanceRequest balanceRequest = new BalanceRequest(null, null, activeProduct.getCost());
        balanceRequest.setProvider(activeProduct.getProduct().getProvider().getId());
        String uri = HTTP + HOST_URL + REDUCER_PORT + REDUCER_URL;
        ObjectMapper objectMapper = new ObjectMapper();
        postRequest(uri, objectMapper.writeValueAsString(balanceRequest));
        uri = HTTP + HOST_URL + REPLENISHER_PORT + REPLENISHER_URL;
        balanceRequest.setProvider(null);
        balanceRequest.setClient(cancelRequest.getClient());
        postRequest(uri, objectMapper.writeValueAsString(balanceRequest));
        uri = HTTP + HOST_URL + ACTIVATOR_PORT + ACTIVATOR_URL + "/cancel";
        postRequest(uri, objectMapper.writeValueAsString(new ActiveProductCancelRequest(activeProduct.getId())));
    }

    @ApiOperation("Внесение средств на счет клиента")
    @PostMapping("/deposit")
    public void deposit(@RequestBody DepositRequest depositRequest) throws JsonProcessingException {
        String uri = HTTP + HOST_URL + REPLENISHER_PORT + REPLENISHER_URL;
        ObjectMapper objectMapper = new ObjectMapper();
        postRequest(uri, objectMapper.writeValueAsString(depositRequest));
    }

    @ApiOperation("Получение списка покупок по продукту")
    @GetMapping("/info")
    public List<ClientPurchaseInfoResponse> getProductInfo(@RequestParam(required = false) String product) {
        List<ProductPurchaseCount> salesList = appService.getProductSaleList(product);
        return salesList.stream()
                .map(s -> new ClientPurchaseInfoResponse(s.getId(), s.getName(), s.getNum()))
                .collect(Collectors.toList());
    }

    private void postRequest(final String uri, String params) {

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uri);
        try {
            httpPost.setEntity(new StringEntity(params));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpClient.execute(httpPost);
        } catch (Exception e) {
            log.error(Arrays.toString(e.getStackTrace()));
        }

    }

    @Data
    @AllArgsConstructor
    private static class BalanceRequest {
        private Integer client;
        private Integer provider;
        private BigDecimal sum;
    }

    @Data
    @AllArgsConstructor
    private static class ActiveProductCancelRequest {
        private int activeProductId;
    }
}