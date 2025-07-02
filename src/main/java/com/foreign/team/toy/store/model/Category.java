package com.foreign.team.toy.store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table(name = "categories")
    public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Category name cannot be blank")
        @Size(max = 30, message = "Category name cannot exceed 30 characters")
        private String name;

        @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Products.Product> products = new ArrayList<>();


        public Category() {}

        public Category(String name) {
            this.name = name;
        }


        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Products.Product> getProducts() {
            return products;
        }

    }

