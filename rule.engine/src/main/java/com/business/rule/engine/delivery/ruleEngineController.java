package com.business.rule.engine.delivery;

import com.business.rule.engine.delivery.model.ProductCategory;
import com.business.rule.engine.delivery.model.ProductCategoryMapper;
import com.business.rule.engine.delivery.request.RuleEngineRequest;
import com.business.rule.engine.domain.RuleEngine;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/rule/apply", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class ruleEngineController {
    private final RuleEngine ruleEngine;
    private String result = "";

    public ruleEngineController(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    @PostMapping
    public String applyRule(@RequestBody RuleEngineRequest ruleEngineRequest) {
        try {
            isValidorderId(ruleEngineRequest.getOrderId());
            ProductCategory productCategory =
                    ProductCategoryMapper.mapToDomain(ruleEngineRequest.getProductCategory());
            result = ruleEngine.go(ruleEngineRequest.getOrderId(), productCategory);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Something wrong");
        }
        return result;
    }

    private void isValidorderId(String orderId) {
        //validate orderID
    }
}

