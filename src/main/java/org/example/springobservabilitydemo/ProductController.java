package org.example.springobservabilitydemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mohamedyoussfi
 **/
@RestController
@Slf4j
public class ProductController {


    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(Product.builder().name("Computer").price(23000).build());
        products.add(Product.builder().name("Smart Phone").price(1200).build());
        products.add(Product.builder().name("Printer").price(300).build());
        products.forEach(product -> log.info(product.toString()));
        return products;
    }

    @GetMapping("/posts")
    public List<Post> allPosts() {

        ResponseEntity<List<Post>> response = restTemplate.exchange(
                "https://jsonplaceholder.typicode.com/posts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        return response.getBody();
    }
}