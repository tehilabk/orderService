package com.consumerservice.repository;

import com.consumerservice.model.entity.LineItemModel;
import org.springframework.data.repository.CrudRepository;

public interface LineItemRepository extends CrudRepository<LineItemModel, Integer> {
}
