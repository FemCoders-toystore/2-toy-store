package com.foreign.team.toy.store.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


public class Products {

    @Entity
    @Table(name = "products")
    public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;

        @NotBlank(message = "Product name is required")
        private String name;

        private double price;
        private String imageUrl;
        private boolean featured;

        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;

        public Product() {
        }

        public Product(String name, Double price, String imageUrl, Boolean featured) {
            this.name = name;
            this.price = price;
            this.imageUrl = imageUrl;
            this.featured = featured;
        }

        public Long getId() {
            return Id;
        }

        public void setId(Long id) {
            Id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

    }
}
