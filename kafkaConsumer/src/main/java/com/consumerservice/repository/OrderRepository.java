package com.consumerservice.repository;

import com.consumerservice.model.entity.OrderModel;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderModel, Integer> {
}
