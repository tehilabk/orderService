package com.example.consumerservice.reposirory;

import com.example.consumerservice.model.entity.LineItemModel;
import org.springframework.data.repository.CrudRepository;

public interface LineItemRepository extends CrudRepository<LineItemModel,Integer> {
}