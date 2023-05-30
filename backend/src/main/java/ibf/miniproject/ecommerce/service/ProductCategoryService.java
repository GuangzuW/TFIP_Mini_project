package ibf.miniproject.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf.miniproject.ecommerce.model.ProductCategory;
import ibf.miniproject.ecommerce.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepo;


    public Integer createProductCategory(String categoryName){
        return productCategoryRepo.createProductCategory(categoryName);
    }

    public int updateProductCategory(Integer id, String categoryName){
        return productCategoryRepo.updateProductCategory(id, categoryName);
    }

    public List<ProductCategory> findAll(){
        return productCategoryRepo.findAll();
    }

    public int deleteProductCategory(Integer id){
        return productCategoryRepo.deleteProductCategory(id);
    }



    
}
