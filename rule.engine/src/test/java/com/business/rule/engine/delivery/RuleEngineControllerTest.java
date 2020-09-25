package com.business.rule.engine.delivery;

import com.business.rule.engine.delivery.model.ProductCategory;
import com.business.rule.engine.delivery.request.RuleEngineRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RuleEngineController.class)
public class RuleEngineControllerTest {
    private static final String ruleEngine = "/rule/apply";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private com.business.rule.engine.domain.action.RuleEngine ruleEngineAction;

    @InjectMocks
    private RuleEngineController ruleEngineController;

    @Test
    public void testSuccessBOOK() throws Exception {
        String result = "Book business rule executed";
        RuleEngineRequest ruleEngineRequest = new RuleEngineRequest();
        ruleEngineRequest.setOrderId("Ksue");
        ruleEngineRequest.setProductCategory(ProductCategory.BOOK);

        when(ruleEngineAction.go("sdf", ProductCategory.BOOK)).thenReturn(result);
        mockMvc.perform(post(ruleEngine)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ruleEngineRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void testSuccessPHYSICAL_PRODUCT() throws Exception {
        String result = "Book business rule executed";
        RuleEngineRequest ruleEngineRequest = new RuleEngineRequest();
        ruleEngineRequest.setOrderId("Ksue");
        ruleEngineRequest.setProductCategory(ProductCategory.PHYSICAL_PRODUCT);

        when(ruleEngineAction.go("sdf", ProductCategory.PHYSICAL_PRODUCT)).thenReturn(result);
        mockMvc.perform(post(ruleEngine)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ruleEngineRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void testSuccessMEMBERSHIP_ACTIVATE() throws Exception {
        String result = "Book business rule executed";
        RuleEngineRequest ruleEngineRequest = new RuleEngineRequest();
        ruleEngineRequest.setOrderId("Ksue");
        ruleEngineRequest.setProductCategory(ProductCategory.MEMBERSHIP_ACTIVATE);

        when(ruleEngineAction.go("sdf", ProductCategory.MEMBERSHIP_ACTIVATE)).thenReturn(result);
        mockMvc.perform(post(ruleEngine)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ruleEngineRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void testSuccessMEMBERSHIP_UPGRADE() throws Exception {
        String result = "Book business rule executed";
        RuleEngineRequest ruleEngineRequest = new RuleEngineRequest();
        ruleEngineRequest.setOrderId("Ksue");
        ruleEngineRequest.setProductCategory(ProductCategory.MEMBERSHIP_UPGRADE);

        when(ruleEngineAction.go("sdf", ProductCategory.MEMBERSHIP_UPGRADE)).thenReturn(result);
        mockMvc.perform(post(ruleEngine)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ruleEngineRequest)))
                .andExpect(status().isOk());
    }
}
