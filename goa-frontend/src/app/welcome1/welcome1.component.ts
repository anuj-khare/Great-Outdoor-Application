import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome1',
  templateUrl: './welcome1.component.html',
  styleUrls: ['./welcome1.component.css']
})
export class Welcome1Component implements OnInit {
  image: string;
  constructor() {
    this.image="./assets/g6.jpg";
  }

  ngOnInit(): void {
  }

}
