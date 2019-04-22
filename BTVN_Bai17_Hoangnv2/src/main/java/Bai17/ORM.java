package Bai17;

import Bai17.entity.Category;
import Bai17.entity.Item;
import Bai17.service.ICategoryService;
import Bai17.service.IItemService;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication

public class ORM implements CommandLineRunner {
    @Autowired
    ICategoryService categoryService;

    @Autowired
    IItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello");
        List<Category> categories = categoryService.findByType("type1",0,5);
        for(Category category : categories){
            System.out.println("Category name is: "+category.getName());
        }

        List<Item> items = itemService.findByCategory("cat1",0,5);
        for (Item i : items){
            System.out.println("Item name is: "+i.getName());
        }

        categoryService.updateCategory((long) 2,"category2");
    }
}
