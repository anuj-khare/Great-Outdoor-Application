import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { OrderService } from '../service/order.service';


@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit {
    orderIdfc : FormControl;
    userIdfc : FormControl;
    productIdfc : FormControl;
    totalPricefc : FormControl;
    totalQuantityfc : FormControl;
    dispatchDatefc : FormControl;
    deliveryDatefc : FormControl;

    orderForm : FormGroup;
    isEditing : boolean;
  dispatchDate:DatePipe;
  deliveryDate : DatePipe;
 

  constructor(private orderService : OrderService, private router : Router,
    private activatedRoute : ActivatedRoute) { 

    this.orderIdfc = new FormControl(null);
    this.productIdfc=new FormControl(null);
    this.userIdfc = new FormControl(null);
    this.totalPricefc = new FormControl(null, Validators.required);
    this.totalQuantityfc = new FormControl(null, Validators.required);
    this.dispatchDatefc = new FormControl(null, Validators.required);
    this.deliveryDatefc = new FormControl(null, Validators.required);

    this.orderForm = new FormGroup({
      orderId : this.orderIdfc,
      userId : this.userIdfc,
      productId:this.productIdfc,
      totalPrice : this.totalPricefc,
      totalQuantity : this.totalQuantityfc,
      dispatchDate : this.dispatchDatefc,
      deliveryDate : this.deliveryDatefc,
    });

    this.isEditing = false;
  }

  ngOnInit() {
     let oid = this.activatedRoute.snapshot.params.oid;
     if (oid) {
       this.isEditing = true;
       this.orderService.findOrdeebyOrderId(oid).subscribe(
        (data) => this.orderForm.setValue(data)
      );
     }
  } 

  handleSubmit() {
     let obr = null;
     if (this.isEditing) {
       obr = this.orderService.updateDate(this.orderForm.value);
     } else {
     obr = this.orderService.addOrder(this.orderForm.value);
     }
    obr.subscribe(
       (data) => this.router.navigateByUrl("/dashboard/order/orderlist")
     );
  }

}
