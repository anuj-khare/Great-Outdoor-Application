import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Growthreport } from '../model/growthreport';

@Injectable({
  providedIn: 'root'
})
export class GrowthreportService {
  growthApi : string;

  constructor(private httpClient : HttpClient) {
    this.growthApi="http://localhost:8082/GrowthReportEntity" ;
  }

  getAll() : Observable<Growthreport[]> {
    return this.httpClient.get<Growthreport[]>(this.growthApi);
  }
  add(growthreport :Growthreport) :Observable<Growthreport>{
    return this.httpClient.post<Growthreport>(this.growthApi,growthreport);
  }

  deleteAll() :Observable<boolean>{
    return this.httpClient.delete<boolean>(this.growthApi);
  }

  deleteById(gid :number) : Observable<boolean> {
    return this.httpClient.delete<boolean>(`${this.growthApi}/${gid}`);
  }

}
