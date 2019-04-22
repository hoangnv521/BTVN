package Bai17.service.Impl;

import Bai17.entity.Category;
import Bai17.entity.Item;
import Bai17.repository.CategoryRepository;
import Bai17.repository.ItemRepository;
import Bai17.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IItemService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findByCategory(String category, int pageIndex, int pageSize) {
        Category category1 = categoryRepository.findByName(category);
        Page<Item> items = itemRepository.findByCategoryId(category1.getId(),new PageRequest(pageIndex,pageSize));
        return items.getContent();
    }
}