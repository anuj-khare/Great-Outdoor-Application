import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-productlist1',
  templateUrl: './productlist1.component.html',
  styleUrls: ['./productlist1.component.css']
})
export class Productlist1Component implements OnInit {
  product : Product[];
  err : string;
  p : number=1;

  constructor(private productService : ProductService, private router: Router) { }

  ngOnInit(): void {
    this.productService.getAll().subscribe(
      (data) => this.product = data,
      (err) => { console.log (err); this.err = "sorry. unable to retrieve data"}
    );
  }

  delete(productId: number) {
    if (confirm("Are you sure?")) {
      this.productService.deleteById(productId).subscribe(
        () => { this.product.splice(this.product.findIndex(e => e.productId == productId), 1) }
      );
    }
  }

  key : string = "productId";
  reverse : boolean = false;
  sort(key){
    this.key = key;
    this.reverse = !this.reverse;
}
}
