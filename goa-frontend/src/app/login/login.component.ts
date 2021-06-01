import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  imageUrl:string;
  constructor() {
    this.imageUrl ="./assets/g5.jpg" ;
  }


  ngOnInit(): void {
  }

}
