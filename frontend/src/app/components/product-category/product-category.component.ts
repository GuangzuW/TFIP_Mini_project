import { Component, OnInit } from '@angular/core';
import { ProductCategory } from 'src/app/model/ProductCategory';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-category',
  templateUrl: './product-category.component.html',
  styleUrls: ['./product-category.component.css']
})
export class ProductCategoryComponent implements OnInit{

  productCategories: ProductCategory[]=[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.listProductCategories();
  }

  listProductCategories(){
    this.productService.getProductCategories().then((result)=>{
      this.productCategories=result;
    }).catch(error => console.log(error));
  }
  
}
