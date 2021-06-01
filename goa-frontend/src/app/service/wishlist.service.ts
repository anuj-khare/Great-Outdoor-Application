import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Wishlist } from '../model/wishlist';


@Injectable({
  providedIn: 'root'
})
export class WishlistService {
  wishlistApi : string ;

  constructor(private httpClient : HttpClient) {
    this.wishlistApi = "http://localhost:8082/WishlistItemEntity";
   }

   getAll() : Observable<Wishlist[]>{
    return this.httpClient.get<Wishlist[]>(this.wishlistApi);
   }
   add(wishlist : Wishlist) : Observable<Wishlist>{
    return this.httpClient.post<Wishlist>(this.wishlistApi,wishlist);
   }
   deleteById(pid :number) : Observable<void>{  
    return this.httpClient.delete<void>(`${this.wishlistApi}/${pid}`);
   }
   getById(wid : number) : Observable<Wishlist>{
     return this.httpClient.get<Wishlist>(`${this.wishlistApi}/${wid}`);
   }
   
   deleteByUserId(uid : string) : Observable<void>{
     return this.httpClient.delete<void>(`${this.wishlistApi}/${uid}`);
   }
   gettByUserId(uid :string): Observable<Wishlist>{
    return this.httpClient.get<Wishlist>(`${this.wishlistApi}/${uid}`);
   }
   getByProductId(pid : string): Observable<Wishlist>{
    return this.httpClient.get<Wishlist>(`{this.wishlistApi}/${pid}`);
   }
}
   

