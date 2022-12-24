package com.example.buysell.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity //Specify for classes that are database relation
        //Class can be entity if: 1.Has @Entity annotation
                                //2.Has no args constructor
                                //3.Not final
                                //4.Has @ID field
        //PARAM: 'name' this name will be used to name the Entity
@Table(name="products") //Helps entity annotation to
                        //PARAM: 'name' is name of table in DB
                        //PARAM: 'schema' specify name of schema for table
                        //If class and table names is the same, that we can ignore this annotation
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id //Specify the primary key for this relation
        //ANY ENTITY MUST HAVE PRIMARY KEY!!!
        //Over field in JPA - 'field-based' access type (working with FIELDS)
        //Over method in JPA - 'property-based' type (working with GETters and SETters)
    @GeneratedValue(strategy = GenerationType.AUTO)//Generate values for field (Sequence)
                                                    //AUTO type is too slow. Better to use @SequenceGenerator with 'initialValue' and 'allocationSize'
                                                    //    example:
                                                    //    @SequenceGenerator(name = "pet_seq",
                                                    //            sequenceName = "pet_sequence",
                                                    //            initialValue = 1, allocationSize = 20)
                                                    //    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
                                                    //    @Column(name = "id", nullable = false)
                                                    //    private Long id;
    @Column(name="id")//Specify column properties in the table
                        //By default the name of the field is the same as the column
                        //PARAM: 'name' name pf the DB column
                        //'unique' unique condition for column value
                        //'nullable' determinate nullability (can contains of null or not)
                        //'length' dimension
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

    @PrePersist//This method will call before table creating (works for insert(persist) or saving operations)
    //@PreUpdate - calls before update rec action
    //Method should return void type and be inside Entity-class
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }
}
