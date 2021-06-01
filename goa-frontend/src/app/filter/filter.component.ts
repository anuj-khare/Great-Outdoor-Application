import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {
  filter : number;
  errMsg : string;
  product : Product;
  search :boolean=false;
  search1 : boolean=false;
  p : number=1;

  constructor(private productservice: ProductService,private router : Router) {
    this.filter = null;

   }

  ngOnInit(): void {
  }

  handleSubmit() {
    this.productservice.getByPrice(this.filter).subscribe((data)=>this.product=data);
  }

   key : string = "productId";
  reverse : boolean = false;
  sort(key){
    this.key = key;
    this.reverse = !this.reverse;
}

}
