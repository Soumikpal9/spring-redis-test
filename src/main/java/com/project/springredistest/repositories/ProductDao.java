package repositories;

import entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductDao {

    public static final String HASH_KEY = "product";
    private final RedisTemplate redisTemplate;

    public Product save (Product product) {
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll () {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Product findById (int id) {
        return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String deleteById (int id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "product removed with id : " + id;
    }

}
