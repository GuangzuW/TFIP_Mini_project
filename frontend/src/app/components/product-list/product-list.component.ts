import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/model/Product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit{
  products: Product[]=[];
  currentCategoryId: number=0;
  searchMode: boolean=false;


  constructor(private productService: ProductService, private route: ActivatedRoute){}
  
  ngOnInit(): void {
    this.route.paramMap.subscribe(()=>{
      this.listProducts();
    });
  }

  listProducts(){
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
    const hasKeyword: boolean = this.route.snapshot.paramMap.has('keyword');
    console.log(hasCategoryId);
    if(hasCategoryId){
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!;
      this.productService.getProductByCategoryId(this.currentCategoryId).then((result)=>{
        this.products=result;
      }).catch(error => console.log(error));
    }else if(hasKeyword){
      const keyword: string = this.route.snapshot.paramMap.get('keyword')!;
      this.productService.searchProducts(keyword).then((result)=>{
        this.products=result;
      }).catch(error => console.log(error));
    }else{
      this.productService.getProducts().then((result)=>{
        this.products=result;
      }).catch(error => console.log(error));
    }
  }


}
