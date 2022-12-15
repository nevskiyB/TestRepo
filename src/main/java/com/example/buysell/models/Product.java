package com.example.buysell.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="description", columnDefinition="text")
    private String description;
    @Column(name="price")
    private int price;
    @Column(name="city")
    private String city;
    @Column(name="author")
    private String author;
    //cascade - тип каскадного поведения(примемер удалять все картинки при удалении product)
    //fetch - тип подгрузки данных из бд(LAZY грузит по мере необходимости)
    //mappedBy - каждая images будет записана в foreign key в таблице img (private Product product;)
    private LocalDateTime dateOfCreated;

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }
}
