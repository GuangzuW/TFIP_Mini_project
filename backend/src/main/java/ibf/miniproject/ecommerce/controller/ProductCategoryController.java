package ibf.miniproject.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf.miniproject.ecommerce.ProductCategoryUtils;
import ibf.miniproject.ecommerce.model.ProductCategory;
import ibf.miniproject.ecommerce.service.ProductCategoryService;

@Controller
@RequestMapping(path = "/api")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService productCategorySvc;

    @GetMapping(path ="productcategories" , produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<String> getAllProductCategories(){
        System.out.println("Inside getAllProductCategories");
        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList = productCategorySvc.findAll();
        return ResponseEntity.ok().body(ProductCategoryUtils.toJson(productCategoryList).toString());
    }
    
}
