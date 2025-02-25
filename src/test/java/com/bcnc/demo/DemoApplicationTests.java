package com.bcnc.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void day14Hour10Test() throws Exception {
        int brandId = 1;
        int productId = 35455;
        String date = "2020-06-14T10:00:00.000+00:00";
        ResultActions result = invokeProductApi(brandId, productId, date);
        assertResultOk(result, productId, brandId, 1, "2020-06-14T00:00:00Z", "2020-12-31T23:59:59Z", 35.50);
    }

    @Test
    void day14Hour16Test() throws Exception {
        int brandId = 1;
        int productId = 35455;
        String date = "2020-06-14T16:00:00.000+00:00";
        ResultActions result = invokeProductApi(brandId, productId, date);
        assertResultOk(result, productId, brandId, 2, "2020-06-14T15:00:00Z", "2020-06-14T18:30:00Z", 25.45);
    }

    @Test
    void day14Hour21Test() throws Exception {
        int brandId = 1;
        int productId = 35455;
        String date = "2020-06-14T21:00:00.000+00:00";
        ResultActions result = invokeProductApi(brandId, productId, date);
        assertResultOk(result, productId, brandId, 1, "2020-06-14T00:00:00Z", "2020-12-31T23:59:59Z", 35.50);
    }

    @Test
    void day15Hour10Test() throws Exception {
        int brandId = 1;
        int productId = 35455;
        String date = "2020-06-15T10:00:00.000+00:00";
        ResultActions result = invokeProductApi(brandId, productId, date);
        assertResultOk(result, productId, brandId, 3, "2020-06-15T00:00:00Z", "2020-06-15T11:00:00Z", 30.50);
    }

    @Test
    void day16Hour21Test() throws Exception {
        int brandId = 1;
        int productId = 35455;
        String date = "2020-06-16T21:00:00.000+00:00";
        ResultActions result = invokeProductApi(brandId, productId, date);
        assertResultOk(result, productId, brandId, 4, "2020-06-15T16:00:00Z", "2020-12-31T23:59:59Z", 38.95);
    }

    private void assertResultOk(ResultActions result, int productId, int brandId, int priceList, String startDate, String endDate, double price) throws Exception {
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId))
                .andExpect(jsonPath("$.priceList").value(priceList))
                .andExpect(jsonPath("$.startDate").value(startDate))
                .andExpect(jsonPath("$.endDate").value(endDate))
                .andExpect(jsonPath("$.price").value(price))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    void notFoundTest() throws Exception {
        int brandId = 1;
        int productId = 35455;
        String date = "2025-06-16T21:00:00.000+00:00";
        ResultActions result = invokeProductApi(brandId, productId, date);
        result.andExpect(status().isNotFound());
    }

    private ResultActions invokeProductApi(int brandId, int productId, String date) throws Exception {
        log.info("Input : Brand: {}, Product: {}, Date: {}", brandId, productId, date);
        ResultActions result =
                mockMvc.perform(get("/v0/brand/{bradId}/product/{productId}", brandId, productId).queryParam(
                        "productDate", date));
        log.info("Result : {}", result.andReturn().getResponse().getContentAsString());
        return result;
    }
}
