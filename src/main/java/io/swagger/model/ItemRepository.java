package io.swagger.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    Item findByItemNo(Integer itemNo);
}
