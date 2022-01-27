package com.geekbrains.market.repositories;

import com.geekbrains.market.entites.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Product findOneByTitle(String title);
}
