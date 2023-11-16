package controller;

import entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import repositories.ProductDao;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductDao productDao;

    @PostMapping
    public Product saveProduct (@RequestBody Product product) {
        return productDao.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts () {
        return productDao.findAll();
    }

    @GetMapping("/{id}")
    public Product findProduct (@PathVariable int id) {
        return productDao.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct (@PathVariable int id) {
        return productDao.deleteById(id);
    }

}
