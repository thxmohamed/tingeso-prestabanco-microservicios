package com.tutorial.evaluation.clients;

import com.tutorial.evaluation.configurations.FeignClientConfig;
import com.tutorial.evaluation.model.CreditModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-credit-service", path = "/request/credit", configuration = {FeignClientConfig.class})
public interface CreditClient {
    @GetMapping("/find/{id}")
    CreditModel getCreditById(@PathVariable Long id);
}
