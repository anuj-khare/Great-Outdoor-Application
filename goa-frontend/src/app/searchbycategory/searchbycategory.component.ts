import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-searchbycategory',
  templateUrl: './searchbycategory.component.html',
  styleUrls: ['./searchbycategory.component.css']
})
export class SearchbycategoryComponent implements OnInit {

  category : string;
  errMsg : string;
  product : Product;
  search :boolean=false;
  search1 : boolean=false;

  constructor(private productservice: ProductService,private router : Router) {
    this.category = "";

   }

  ngOnInit(): void {
  }

  handleSubmit() {
    this.productservice.getByCategory(this.category).subscribe((data)=>this.product=data);
  }
}
