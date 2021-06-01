import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../service/cart.service';

@Component({
  selector: 'app-cart-update',
  templateUrl: './cart-update.component.html',
  styleUrls: ['./cart-update.component.css']
})
export class CartUpdateComponent implements OnInit {
  cartIdfc : FormControl;
  userIdfc : FormControl;
  productIdfc : FormControl;
 // quantityfc : FormControl;
  cartTotalPricefc : FormControl;
  totalQuantityfc : FormControl;

  cartForm : FormGroup;
  isEditing : boolean;

constructor(private cartService : CartService, private router : Router,
  private activatedRoute : ActivatedRoute) { 

  // this.cartIdfc = new FormControl(null, Validators.required);
  this.cartIdfc = new FormControl(null);
  this.userIdfc = new FormControl(null);
  this.productIdfc=new FormControl(null);
  this.cartTotalPricefc = new FormControl(null, Validators.required);
  this.totalQuantityfc = new FormControl(null, Validators.required);

  this.cartForm = new FormGroup({
    cartId : this.cartIdfc,
    userId : this.userIdfc,
    productId:this.productIdfc,
    cartTotalPrice : this.cartTotalPricefc,
    totalQuantity : this.totalQuantityfc,
  });

  this.isEditing = false;
}


  ngOnInit(): void {    
    let cid = this.activatedRoute.snapshot.params.cid;
    if (cid) {
      this.isEditing = true;
      this.cartService.getById(cid).subscribe(
        (data) => {this.cartForm.setValue(
    data

        );
      }
      )
    }
  }


  handleSubmit() {
   let obr = this.cartService.updateCart(this.cartForm.value).subscribe(
    (data) => this.router.navigateByUrl("/dashboard/cart/cartlist")
   );
  }

}
