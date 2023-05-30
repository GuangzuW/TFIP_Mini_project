import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/model/Product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit{

  product!: Product;

  constructor(private productService: ProductService, private route: ActivatedRoute) { }

  ngOnInit(): void{
    this.productDetails();
  }  
  productDetails(){
    const productId: number = +this.route.snapshot.paramMap.get('id')!;
    this.productService.getProductDetails(productId).then((result)=>{
      console.log(result);
      this.product=result;
    }).catch(error => console.log(error));
  }

}
