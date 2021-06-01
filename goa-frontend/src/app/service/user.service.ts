import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  userApi : string;

  constructor(private httpClient : HttpClient) {
    this.userApi="http://localhost:8082/Userdata" ;
  }

  
  addUser(user :User) :Observable<User>{
    return this.httpClient.post<User>(this.userApi,user);
  }

  loginUser(uid :number , password:string) : Observable<string> {
    return  this.httpClient.get<string>(`${this.userApi}/${uid},${password}`,{responseType:'text' as 'json'});
  }

  loginadmin(uid :number , password:string) : Observable<string> {
    return  this.httpClient.get<string>(`${this.userApi}/login/${uid},${password}`,{responseType:'text' as 'json'});
  }

  logout() : Observable<string> {
    return  this.httpClient.get<string>(`${this.userApi}`);
  }
}
