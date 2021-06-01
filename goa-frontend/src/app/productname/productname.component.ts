import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-productname',
  templateUrl: './productname.component.html',
  styleUrls: ['./productname.component.css']
})
export class ProductnameComponent implements OnInit {
  productname : string;
  errMsg : string;
  product : Product;
  search :boolean=false;
  search1 : boolean=false;

  constructor(private productservice: ProductService,private router : Router) {
    this.productname = null;

   }

  ngOnInit(): void {
  }

  handleSubmit() {
    this.productservice.getByProductName(this.productname).subscribe
    ((data)=>
    this.product=data);
  }
}
