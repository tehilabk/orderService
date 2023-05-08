package com.orderservice.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderservice.model.LineItemModel;
import com.orderservice.model.OrderModel;
import com.orderservice.service.OrderEventProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderServiceController.class)
@AutoConfigureMockMvc
public class OrderServiceControllerUnitTest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    @MockBean
    OrderEventProducer orderEventProducer;

    @Test
    void postOrderValidEvent() throws Exception {
        LineItemModel item = new LineItemModel(1211L,"computer","black computer",5000L,1);
        List<LineItemModel> lineItemModelList = new ArrayList<>();
        lineItemModelList.add(item);
        OrderModel order = new OrderModel(new Date(),"tehilabk123@gmail.com","tehila", "ben kalifa", lineItemModelList);
        order.setStoreId(1L);
        String json = objectMapper.writeValueAsString(order);

        //expect
        mockMvc.perform(post("/1/orders")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void postOrderWithEmptyOrderFieldEvent() throws Exception {

        OrderModel order = new OrderModel(new Date(),"tehilabk123@gmail.com","tehila", "ben kalifa", new ArrayList<>());
        order.setStoreId(1L);
        String json = objectMapper.writeValueAsString(order);

        //expect
        mockMvc.perform(post("/1/orders")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    void postOrderWithEmptyItemFieldEvent() throws Exception {

        LineItemModel item = new LineItemModel(1211L,"","black computer",5000L,1);
        List<LineItemModel> lineItemModelList = new ArrayList<>();
        lineItemModelList.add(item);
        OrderModel order = new OrderModel(new Date(),"tehilabk123@gmail.com","tehila", "ben kalifa", lineItemModelList);
        order.setStoreId(1L);
        String json = objectMapper.writeValueAsString(order);

        //expect
        mockMvc.perform(post("/1/orders")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void postOrderNotValidMailEvent() throws Exception {
        LineItemModel item = new LineItemModel(1211L,"computer","black computer",5000L,1);
        List<LineItemModel> lineItemModelList = new ArrayList<>();
        lineItemModelList.add(item);
        OrderModel order = new OrderModel(new Date(),"tehilab","tehila", "ben kalifa", lineItemModelList);
        order.setStoreId(1L);
        String json = objectMapper.writeValueAsString(order);

        //expect
        mockMvc.perform(post("/1/orders")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }



}
