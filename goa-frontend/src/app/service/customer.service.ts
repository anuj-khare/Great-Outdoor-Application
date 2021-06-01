import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customerApi : string;
  customerApi1: string

  constructor(private httpClient : HttpClient) {
    this.customerApi="http://localhost:8082/CustomerEntity/" ;
    this.customerApi1="http://localhost:8082/CustomerEntity/viewCustomer" ;

  }

  
  getAll() : Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.customerApi);
  }

  add(customer :Customer) :Observable<Customer>{
    return this.httpClient.post<Customer>(this.customerApi,customer);
  }

  update(customer :Customer) :Observable<Customer>{
    return this.httpClient.put<Customer>(this.customerApi,customer);
  }

  delete(customerId :number) :Observable<Boolean>{
    return this.httpClient.delete<Boolean>(`${this.customerApi}/${customerId}`);
  }

  viewCustomer(customer :Customer) : Observable<Customer> {
    return this.httpClient.get<Customer>(`${this.customerApi1,customer}`);
  }

  getById(customerId:number) :Observable<Customer> {
    return this.httpClient.get<Customer>(`${this.customerApi}/${customerId}`);
  }
  
}
