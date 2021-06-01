import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Salesreport } from '../model/salesreport';

@Injectable({
  providedIn: 'root'
})
export class SalesreportService {
  salesreportApi : string;

  constructor(private httpClient : HttpClient) {
    this.salesreportApi="http://localhost:8082/SalesReportEntity" ;
  }


  getAll() : Observable<Salesreport[]> {
    return this.httpClient.get<Salesreport[]>(this.salesreportApi);
  }
  
  getById(sid :number) : Observable<Salesreport> {
   return  this.httpClient.get<Salesreport>(`${this.salesreportApi}/${sid}`);
  }

  
  updateQuantity(salesreport:Salesreport) :Observable<Salesreport>{
     return this.httpClient.put<Salesreport>(`${this.salesreportApi}/${salesreport.salesReportId},${salesreport.quantitySold},${salesreport.totalSale}`,salesreport);
   }

  deleteById(sid :number) : Observable<void> {
    return this.httpClient.delete<void>(`${this.salesreportApi}/deletesalesreportby/${sid}`);
  }


  deleteAll() :Observable<Salesreport[]>{
    return this.httpClient.delete<Salesreport[]>(this.salesreportApi);
  }

  
}
