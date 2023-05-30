package ibf.miniproject.ecommerce.service;

import ibf.miniproject.ecommerce.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf.miniproject.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepo;

    public List<Product> findAll(){
        return productRepo.findAll();
    }

    public Product findById(Integer id){
        return productRepo.findById(id);
    }

    public Integer createProduct(Product product){
        return productRepo.createProduct(product);
    }

    public int updateProduct(Product product){
        return productRepo.updateProduct(product);
    }

    public int deleteProduct(Integer id){
        return productRepo.deleteProduct(id);
    }

    public List<Product> findByCategoryId(Integer categoryId){
        return productRepo.findByCategoryId(categoryId);
    }

    public List<Product> findByNameContains(String name){
        return productRepo.findByKeyword(name);
    }

}
