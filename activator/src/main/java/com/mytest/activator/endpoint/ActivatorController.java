package com.mytest.activator.endpoint;

import com.mytest.activator.ActivatorService;
import com.mytest.activator.dto.CancelRequest;
import com.mytest.activator.dto.SellRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(tags = "Контроллер сервиса активации")
@RestController
@RequestMapping(value = "/activator", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ActivatorController {

    private final ActivatorService activatorService;

    @ApiOperation("Активация продукта/услуги")
    @PostMapping("/sell")
    public void sell(@RequestBody SellRequest sellRequest) {
        activatorService.sell(sellRequest);
    }

    @ApiOperation("Отмена услуги")
    @PostMapping("/cancel")
    public void cancel(@RequestBody CancelRequest cancelRequest) {
        activatorService.deactivate(cancelRequest);
    }
}
