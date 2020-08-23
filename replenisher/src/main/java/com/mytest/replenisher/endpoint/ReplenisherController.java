package com.mytest.replenisher.endpoint;

import com.mytest.replenisher.ReplenisherService;
import com.mytest.replenisher.dto.ReplenishRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(tags = "Контроллер сервиса пополнения")
@RestController
@RequestMapping(value = "/replenisher", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ReplenisherController {

    private final ReplenisherService replenisherService;

    @ApiOperation("Пополнение баланса")
    @PostMapping()
    public void replenish(@RequestBody ReplenishRequest replenishRequest) {
        if(replenishRequest.getClient() != null)
            replenisherService.replenishClientBalance(replenishRequest.getClient(),replenishRequest.getSum());
        if(replenishRequest.getProvider() != null)
            replenisherService.replenishProviderBalance(replenishRequest.getProvider(),replenishRequest.getSum());
    }
}
