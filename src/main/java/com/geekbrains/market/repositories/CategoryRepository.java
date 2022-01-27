package com.geekbrains.market.repositories;

import com.geekbrains.market.entites.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByTitle(String title);
}
