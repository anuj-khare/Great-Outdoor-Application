import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../service/cart.service';

@Component({
  selector: 'app-add-cart-to-order',
  templateUrl: './add-cart-to-order.component.html',
  styleUrls: ['./add-cart-to-order.component.css']
})
export class AddCartToOrderComponent implements OnInit {
  cartIdfc : FormControl;
  userIdfc : FormControl;
  productIdfc : FormControl;
  cartTotalPricefc : FormControl;
  totalQuantityfc : FormControl;

  cartForm : FormGroup;
  isEditing : true;
  infoMsg:string;
  errMsg:string;
constructor(private cartService : CartService, private router : Router,
  private activatedRoute : ActivatedRoute) { 

  // this.cartIdfc = new FormControl(null, Validators.required);
  this.cartIdfc = new FormControl();
  this.userIdfc = new FormControl();
  this.productIdfc=new FormControl(null);
  this.cartTotalPricefc = new FormControl(null );
  this.totalQuantityfc = new FormControl(null);

  this.cartForm = new FormGroup({
    cartId : this.cartIdfc,
    userId : this.userIdfc,
    productId:this.productIdfc,
    cartTotalPrice : this.cartTotalPricefc,
    totalQuantity : this.totalQuantityfc,
  });
     }

  ngOnInit(): void { 
    let cid = this.activatedRoute.snapshot.params.cid;
    if (cid) {
      this.cartService.getById(cid).subscribe(
        (data) => {this.cartForm.setValue(data)
      }
      );
    }
    this.activatedRoute.queryParams
    .subscribe(
      (params) =>{
        if(params.msg){
          this.infoMsg=params.msg;
        }
      }
    );
  }

  handleSubmit() {
    console.log(this.cartForm.value);
    let obr=this.cartService.carttoorder(this.cartForm.value).subscribe(
    (data)=> {console.log(data),
      this.router.navigateByUrl("/dashboard/order/orderlist")},
      (err)=>{
        this.errMsg=err.error;
      }
    );
  }

}
