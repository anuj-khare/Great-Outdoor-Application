import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  infoMsg:string;
  errMsg:string;
  imageUrl:string;


  constructor() {
    this.imageUrl= "./assets/g3.jpg" ;
   }

  ngOnInit(): void {
  }


  onSubmit(){
   }
}
