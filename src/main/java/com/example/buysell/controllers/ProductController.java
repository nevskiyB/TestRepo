package com.example.buysell.controllers;

import com.example.buysell.models.Product;
import com.example.buysell.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * Controller-class.
 * Consists of methods that return views for pages display
 * */
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService service) {
        this.productService = service;
    }

    /**
     * @return name of freemarker view file
     * */
    @GetMapping("/")//Used to create a web service endpoint
    public String products(@RequestParam(name="title", required = false) String title,//Annotation used for retrieve request params
                                                                                    //Attribute: 1.'(name=<param alias>)' or (<param alias>)
                                                                                    //2.(required=false) for mandatory params
                                                                                    //3.(defaultValue='example') value will set for field
                                                                                    //Its possible to pass list of params
                           Model model){ // interface for transfer data from endpoint to view
        model.addAttribute("productList", productService.list(title));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {//Annotation allows to pass no-named param in URL
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) throws IOException {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/";
    }
}
