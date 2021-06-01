import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-header1',
  templateUrl: './header1.component.html',
  styleUrls: ['./header1.component.css']
})
export class Header1Component implements OnInit {

  constructor(private router : Router) {  }

  ngOnInit(): void {
  }

  signOut(){
    this.router.navigateByUrl("/applogin");
  }

}
