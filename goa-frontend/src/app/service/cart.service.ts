import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cart } from '../model/cart';


@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartApi : string;

  constructor(private httpClient : HttpClient) {
    this.cartApi="http://localhost:8082/CartItemEntity" ;
  }

  findCartlist() : Observable<Cart[]> {
    return this.httpClient.get<Cart[]>(`${this.cartApi}`);
  }
  
  findCartItem(cartId: number) : Observable<Cart> {
    return this.httpClient.get<Cart>(`${this.cartApi}/${cartId}`);
  }
  
  addCart(cart : Cart) : Observable<Cart> {
    return this.httpClient.post<Cart>(this.cartApi,cart);
  }
  
  updateCart(cart : Cart) : Observable<Cart> {
    return this.httpClient.put<Cart>(`${this.cartApi}/${cart.cartId},${cart.totalQuantity}`,cart);
  }
  
  deleteCartItem(cartId : number, productId : number) : Observable<void> {
    return this.httpClient.delete<void>(`${this.cartApi}/${cartId},${productId}`);
  }
  
  deleteCartlist(userId : number) : Observable<void> {
    return this.httpClient.delete<void>(`${this.cartApi}/deleteCart/${userId}`);
  }


  getById(cartId:number): Observable<Cart>{
    return this.httpClient.get<Cart>(`${this.cartApi}/${cartId}`);
  }

  carttoorder(cart:Cart): Observable<boolean> {
    return this.httpClient.put<boolean>(`${this.cartApi}/carttoorder/${cart.cartId},${cart.userId}`,cart);
   }
  
}
