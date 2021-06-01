import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../model/cart';
import { Order } from '../model/order';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  productApi : string;
  productApi1 : string;
  productApi2 : string;
  productApi3 : string;
  productApi4 : string;


  constructor(private httpClient : HttpClient) {
    this.productApi="http://localhost:8082/ProductEntity" ;
    this.productApi1="http://localhost:8082/ProductEntity/findByProductId/" ;
    this.productApi2="http://localhost:8082/ProductEntity/findByProductCategory/" ;
    this.productApi3="http://localhost:8082/ProductEntity/filter/" ;
  }

  getAll() : Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.productApi);
  }

  getById(pid :number) : Observable<Product> {
    return  this.httpClient.get<Product>(`${this.productApi1}/${pid}`);
  }

  getByCategory(cat : string) : Observable<Product> {
    return  this.httpClient.get<Product>(`${this.productApi2}/${cat}`);
  }
  add(product :Product) :Observable<Product>{
    return this.httpClient.post<Product>(this.productApi,product);
  }

  update(product :Product) :Observable<Product>{
    return this.httpClient.put<Product>(this.productApi,product);
  }

  updateQuantity(pid :number,quan :number ) :Observable<Product>{
    return this.httpClient.put<Product>(`${this.productApi}/${quan}`,`${this.productApi}/${pid}`);
  }

  deleteById(pid :number) : Observable<void> {
    return this.httpClient.delete<void>(`${this.productApi}/${pid}`);
  }
  getByProductName(pname : string) : Observable<Product> {
    return  this.httpClient.get<Product>(`${this.productApi}/${pname}`);
  }
  getByPrice(price :number) : Observable<Product> {
    return  this.httpClient.get<Product>(`${this.productApi3}/${price}`);
  }


  AddproductTocart(pid:number,cid :Cart): Observable<boolean>{
    return this.httpClient.put<boolean>(`${this.productApi}/updateCart/${pid},${cid.userId},${cid.totalQuantity}`,cid)
  }

  AddproductToorder(pid:number,cid :Order): Observable<boolean>{
    return this.httpClient.put<boolean>(`${this.productApi}/updateOrder/${pid},${cid.userId},${cid.totalQuantity}`,cid)
  }
}
