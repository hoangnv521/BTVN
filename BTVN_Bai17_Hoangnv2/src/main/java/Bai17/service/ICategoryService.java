package Bai17.service;

import Bai17.entity.Category;


import java.util.List;

public interface ICategoryService {
    List<Category> findByType (String type, int pageIndex, int pageSize);
    void updateCategory(Long id, String name);
}
