package com.vyatsu.services;

import com.vyatsu.entities.Product;
import com.vyatsu.entities.ProductSpecification;
import com.vyatsu.repositories.Filter;
import com.vyatsu.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ProductsService {
    @Autowired
    private ProductRepository productRepository;

    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Page<Product> getFilterProducts(Filter filter, Pageable pageable){
        int min;
        try{
            min = Math.toIntExact(filter.getMinPrice());
        }catch (Exception e){
            min = 0;
        }
        int max;
        try{
            max = Math.toIntExact(filter.getMaxPrice());
        }catch (Exception e){
            max = 100000;
        }

        String text = filter.getText();
        return (Page<Product>) productRepository
                .findAll(Specification
                        .where(ProductSpecification.minValue(min))
                        .and(ProductSpecification.maxValue(max))
                        .and(ProductSpecification
                                .hasText(text.toLowerCase(Locale.ROOT))), pageable);
    }

    public void save(Product product) {
        if (product.getId() != null)product.setCount(this.getById(product.getId()).getCount());
        productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public void deleteByID(Long ID) {
        productRepository.deleteById(ID);
    }
    public List<Product> findTop(){
        return productRepository.findAll(new Sort(Sort.Direction.DESC, "count"))
                .stream()
                .limit(3)
                .collect(Collectors.toList());
    }
}
