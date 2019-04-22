package Bai17.service;

import Bai17.entity.Item;


import java.util.List;

public interface IItemService {
    List<Item> findByCategory(String category, int pageIndex, int pageSize);
}
