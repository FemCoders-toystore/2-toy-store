package com.foreign.team.toy.store.repository;

import com.foreign.team.toy.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    boolean existsByName(String name);
    List<Product> findByCategoryNameIgnoreCase(String categoryName);
}






