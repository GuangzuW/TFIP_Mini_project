import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, lastValueFrom } from 'rxjs';
import { map } from 'rxjs/operators';
import { Product } from '../model/Product';
import { ProductCategory } from '../model/ProductCategory';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api';


  constructor(private httpClient: HttpClient) { }


  getProducts(): Promise<Product[]> {
    const productsUrl=`${this.baseUrl}/products`
    return lastValueFrom(this.httpClient.get<Product[]>(productsUrl));
  }

  getProductDetails(id:number): Promise<Product> {
    const productsUrl=`${this.baseUrl}/products/${id}`
    return lastValueFrom(this.httpClient.get<Product>(productsUrl));
  }

  getProductByCategoryId(categoryId: number): Promise<Product[]>{
    const serachByCategoryUrl =`${this.baseUrl}/products/search/findbycategoryid?id=${categoryId}`;
    return lastValueFrom(this.httpClient.get<Product[]>(serachByCategoryUrl));
  }
  
  getProductCategories(): Promise<ProductCategory[]>{
    const productCategoriesUrl = `${this.baseUrl}/productcategories`;
    return lastValueFrom(this.httpClient.get<ProductCategory[]>(productCategoriesUrl));
  }

  searchProducts(keyword: string): Promise<Product[]>{
    const searchUrl = `${this.baseUrl}/products/search/findbynamecontains?name=${keyword}`;
    return lastValueFrom(this.httpClient.get<Product[]>(searchUrl));
  }



}


