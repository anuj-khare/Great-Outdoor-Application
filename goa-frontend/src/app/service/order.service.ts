
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../model/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  orderApi : string;

  constructor(private httpClient : HttpClient) {
    this.orderApi="http://localhost:8082/OrderEntity" ;
  }

  findOrdeebyOrderId(orderId : number) : Observable<Order> {
    return this.httpClient.get<Order>(`${this.orderApi}/${orderId}`);
  }
  
  findAllOrders() : Observable<Order[]> {
    return this.httpClient.get<Order[]>(this.orderApi);
  }
  
  addOrder(order:Order) : Observable<Order> {
    return this.httpClient.post<Order>(this.orderApi,order);
  }
  
  deleteAllOrders() : Observable<void> {
      return this.httpClient.delete<void>(`${this.orderApi}`);
    }
  
  deleteOrderById(orderId : number) : Observable<void> {
      return this.httpClient.delete<void>(`${this.orderApi}/${orderId}`);
    }
  
    updateDate(order:Order ) : Observable<Order> {
      return this.httpClient.put<Order>(`${this.orderApi}/${order.orderId},${order.dispatchDate},${order.deliveryDate}`,order);
    }

  // updateDate(orderId : number, dispatchDate : DatePipe, arrivalDate : DatePipe ) : Observable<Order> {
  //   return this.httpClient.put<Order>(`${this.orderApi}/${orderId},${dispatchDate},${arrivalDate}`);
  // }

   getByUserId(order:Order): Observable<Order> {
    return this.httpClient.get<Order>(`${this.orderApi}/order/${order.userId}`);
   }



}
