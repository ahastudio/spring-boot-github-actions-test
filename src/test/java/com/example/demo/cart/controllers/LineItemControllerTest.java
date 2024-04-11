package com.example.demo.cart.controllers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class LineItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // TODO: Clear cart and enable this test!
    @Disabled
    @Test
    @DisplayName("GET /cart/line-items - when cart is empty")
    void testListWithNoLineItem() throws Exception {
        // TODO: Clear cart.

        mockMvc.perform(get("/cart/line-items"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"lineItems\":[]")
                ));
    }

    @Test
    @DisplayName("GET /cart/line-items - when cart has line items")
    void testListWithLineItems() throws Exception {
        // TODO: Prepare cart.

        mockMvc.perform(get("/cart/line-items"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"lineItems\":[{")
                ));
    }

    @Test
    @DisplayName("POST /cart/line-items - when user add a new product")
    void testAddNewItem() throws Exception {
        // TODO: Clear cart.

        String json = """
                {
                    "productId": "product-1",
                    "quantity: 2
                }
                """;

        mockMvc.perform(post("/cart/line-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());

        // TODO: Check count of cart line items.
        // TODO: Check quantity of the first line item.
    }

    @Test
    @DisplayName("POST /cart/line-items - when user add a same product")
    void testAddSameItem() throws Exception {
        // TODO: Prepare cart.

        String json = """
                {
                    "productId": "product-1",
                    "quantity: 2
                }
                """;

        mockMvc.perform(post("/cart/line-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());

        // TODO: Check count of cart line items.
        // TODO: Check quantity of the first line item.
    }

    @Test
    @DisplayName("POST /cart/line-items - when user add a different product")
    void testAddDifferentItem() throws Exception {
        // TODO: Prepare cart.

        String json = """
                {
                    "productId": "product-1",
                    "quantity: 2
                }
                """;

        mockMvc.perform(post("/cart/line-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());

        // TODO: Check count of cart line items.
        // TODO: Check quantity of the first line item.
        // TODO: Check quantity of the second line item.
    }
}
