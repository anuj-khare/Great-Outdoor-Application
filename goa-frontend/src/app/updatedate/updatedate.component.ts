import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-updatedate',
  templateUrl: './updatedate.component.html',
  styleUrls: ['./updatedate.component.css']
})
export class UpdatedateComponent implements OnInit {
  orderId : number;
  dispatchDate:DatePipe;
  deliveryDate : DatePipe;
  errMsg : string;
  order : Order[];
  search :boolean=false;
  search1 : boolean=false;
  constructor(private orderservice: OrderService,private router : Router,private activatedRoute : ActivatedRoute) { }

  ngOnInit(): void { 
  }
  handleSubmit() {
    // this.orderservice.updateDate(this.orderId,this.dispatchDate,this.deliveryDate).subscribe(
    //   (data)=>{this.order.splice(this.order.findIndex(e => e.orderId == this.orderId), 1) }
    //   );
  }
}
