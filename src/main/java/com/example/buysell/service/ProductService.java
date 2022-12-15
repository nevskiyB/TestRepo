package com.example.buysell.service;

import com.example.buysell.models.Product;
import com.example.buysell.repositories.IProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final IProductRepository repo;

    //@Autowired
    public ProductService(IProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> list(String title) {
        if(title != null && !title.isEmpty())
            return repo.findByTitle(title);
        return repo.findAll();
    }

    public void saveProduct(Product product) throws IOException {
        repo.save(product);
    }

    public Product getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
