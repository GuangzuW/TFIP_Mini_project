import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subscriber, lastValueFrom } from 'rxjs';
import { map } from 'rxjs/operators';
import { Product } from '../model/Product';
import { ProductCategory } from '../model/ProductCategory';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  page = 1;
  pageSize = 10;

  
  private baseUrl = 'http://localhost:8080/api';
  // mysql://root:2Q0aGz47FbxniP4PS0vg@containers-us-west-30.railway.app:5748/railway
  //mysql://root:2Q0aGz47FbxniP4PS0vg@containers-us-west-30.railway.app:5748/railway


  constructor(private httpClient: HttpClient) { }


  getProducts(): Promise<Product[]> {
    const productsUrl=`${this.baseUrl}/products`
    // return lastValueFrom(this.httpClient.get<Product[]>(productsUrl));
    return lastValueFrom(this.httpClient.get<Product[]>('/api/products'));
  }
  

  getProductDetails(id:number): Promise<Product> {
    const productsUrl=`${this.baseUrl}/products/${id}`
    // return lastValueFrom(this.httpClient.get<Product>(productsUrl));
    return lastValueFrom(this.httpClient.get<Product>(`/api/products/${id}`));
  }

  getProductByCategoryId(categoryId: number): Promise<Product[]>{
    const serachByCategoryUrl =`${this.baseUrl}/products/search/findbycategoryid?id=${categoryId}`;
    // return lastValueFrom(this.httpClient.get<Product[]>(serachByCategoryUrl));
    return lastValueFrom(this.httpClient.get<Product[]>(`/api/products/search/findbycategoryid?id=${categoryId}`));

  }
  
  getProductCategories(): Promise<ProductCategory[]>{
    const productCategoriesUrl = `${this.baseUrl}/productcategories`;
    // return lastValueFrom(this.httpClient.get<ProductCategory[]>(productCategoriesUrl));
    return lastValueFrom(this.httpClient.get<ProductCategory[]>('/api/productcategories'));
  }

  searchProducts(keyword: string): Promise<Product[]>{
    const searchUrl = `${this.baseUrl}/products/search/findbynamecontains?name=${keyword}`;
    // return lastValueFrom(this.httpClient.get<Product[]>(searchUrl));
    return lastValueFrom(this.httpClient.get<Product[]>(`/api/products/search/findbynamecontains?name=${keyword}`));

  }



}


