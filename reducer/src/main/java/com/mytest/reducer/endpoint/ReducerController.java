package com.mytest.reducer.endpoint;

import com.mytest.reducer.ReducerService;
import com.mytest.reducer.dto.ReduceRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(tags = "Контроллер сервиса списания")
@RestController
@RequestMapping(value = "/reducer", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ReducerController {

    private final ReducerService reducerService;

    @ApiOperation("Списание баланса")
    @PostMapping()
    public void reduce(@RequestBody ReduceRequest reduceRequest) {
        if(reduceRequest.getClient() != null)
            reducerService.reduceClientBalance(reduceRequest.getClient(),reduceRequest.getSum());
        if(reduceRequest.getProvider() != null)
            reducerService.reduceProviderBalance(reduceRequest.getProvider(),reduceRequest.getSum());
    }
}
