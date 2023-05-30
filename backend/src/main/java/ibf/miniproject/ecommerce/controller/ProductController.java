package ibf.miniproject.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf.miniproject.ecommerce.ProductUtils;
import ibf.miniproject.ecommerce.model.Product;
import ibf.miniproject.ecommerce.service.ProductService;

@Controller
@RequestMapping(path="/api")    
public class ProductController {


    @Autowired
    ProductService productSvc;

    @GetMapping(path="/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllProduct(){
        System.out.println("Inside getAllProduct");
        List<Product> productList = new ArrayList<>();
        productList = productSvc.findAll();
        return ResponseEntity.ok().body(ProductUtils.toJson(productList).toString());
    }

    @GetMapping(path="/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getProductById(@PathVariable(required=true) String id){
        System.out.println("Inside getProductById");
        try {
            Product product = productSvc.findById(Integer.parseInt(id));
            return ResponseEntity.ok().body(ProductUtils.productToJson(product).toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid product id");
        }
    }



    @GetMapping(path="/products/search/findbycategoryid", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getProductByCategoryId(@RequestParam Integer id){
        System.out.println("Inside getProductByCategoryId");
        List<Product> productList = new ArrayList<>();
        productList = productSvc.findByCategoryId(id);
        System.out.println(productList.get(0).toString());
        return ResponseEntity.ok().body(ProductUtils.toJson(productList).toString());
    }

    @GetMapping(path="products/search/findbynamecontains", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getProductByNameContains(@RequestParam String name){
        System.out.println("Inside getProductByNameContains");
        List<Product> productList = new ArrayList<>();
        productList = productSvc.findByNameContains(name);
        return ResponseEntity.ok().body(ProductUtils.toJson(productList).toString());
    }


    @GetMapping(path="/product/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        System.out.println("Inside createProduct");
        Integer id = productSvc.createProduct(product);
        return ResponseEntity.ok().body("Product created with id: " + id);
    }


}
