package ru.mysak.springboot.crudbookshop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import ru.mysak.springboot.crudbookshop.entity.Product;
import ru.mysak.springboot.crudbookshop.repository.ProductRepository;

import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    @Transactional
    @Lock(value = LockModeType.READ)
    public void update(Product product) {
        try {
            productRepository.save(product);
        }
        catch (OptimisticLockException exc) {
            log.warn("Optimistic lock exception for product {}: ", product.getId());
        }
    }
}
