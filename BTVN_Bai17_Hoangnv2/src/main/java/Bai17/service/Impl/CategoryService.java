package Bai17.service.Impl;

import Bai17.entity.Category;
import Bai17.repository.CategoryRepository;
import Bai17.repository.TypeRepository;
import Bai17.service.ICategoryService;

import Bai17.entity.Type;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TypeRepository typeRepository;

    @Override
    public List<Category> findByType(String type, int pageIndex, int pageSize) {
        Page<Category> categories = categoryRepository.findByTypesId(typeRepository.findByName(type).getId(),new PageRequest(pageIndex,pageSize));
        return categories.getContent();
    }

    @Override
    @Transactional
    public void updateCategory(Long id, String name) {
        if (categoryRepository.findById(id).isPresent()){
            Category category  = categoryRepository.findById(id).get();
            category.setName(name);
            categoryRepository.save(category);
            System.out.println("Update category with id = "+id+" success!!!");
            System.out.println("Category new name is: "+name);
        }else {
            System.out.println("Category with id = "+id+" is not exist!!!");
        }

    }
}
