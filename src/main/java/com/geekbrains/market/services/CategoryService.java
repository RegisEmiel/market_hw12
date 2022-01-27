package com.geekbrains.market.services;

import com.geekbrains.market.entites.Category;
import com.geekbrains.market.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return (List<Category>)categoryRepository.findAll();
    }

    public Category findByTitle(String title) {
       /* ArrayList<Category> list = (ArrayList<Category>) categoryRepository.findAll();

        for (Category category: list) {
            if (title.equals(category.getTitle()))
                return category;
        }

        return null;*/

        return categoryRepository.findByTitle(title);
    }
}