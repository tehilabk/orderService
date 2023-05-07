package com.example.consumerservice.reposirory;
import com.example.consumerservice.model.entity.OrderModel;
import org.springframework.data.repository.CrudRepository;
public interface OrderRepository extends CrudRepository<OrderModel,Integer> {
}
