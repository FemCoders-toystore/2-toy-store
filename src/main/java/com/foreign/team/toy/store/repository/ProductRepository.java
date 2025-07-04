package com.foreign.team.toy.store.repository;

import com.foreign.team.toy.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Puedes agregar métodos personalizados aquí si quieres
}
