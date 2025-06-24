package org.example.springobservabilitydemo;


import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Product {
    private Long id;
    private String name;
    private double price;
}
