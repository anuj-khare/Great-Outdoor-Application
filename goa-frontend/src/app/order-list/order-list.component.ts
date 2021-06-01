
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from '../model/order';
import { User } from '../model/user';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})

export class OrderListComponent {

  order: Order[];
  err: string;
  user:User;
  p : number=1;

  constructor(private orderService: OrderService,private router:Router,private activatedRoute : ActivatedRoute) { }

  ngOnInit() {
     this.orderService.findAllOrders().subscribe(
      (data) => this.order = data,
       (err) => { console.log (err); this.err = "sorry. unable to retrieve data"}
      );
     let oid = this.activatedRoute.snapshot.params.oid;
      if (oid) {
        this.orderService.getByUserId(oid).subscribe(
         (data) => this.order.splice(this.order.findIndex(o => o.userId == oid), 1)
       );
      }

  }

  delete(orderId:number ) {
    if (confirm("Are you sure?")) {
      this.orderService.deleteOrderById(orderId).subscribe(
        () => { this.order.splice(this.order.findIndex(o => o.orderId == orderId), 1) }
      );
    }
  }

  deleteall() {
    if (confirm("Are you sure?")) {
      let obr=null;
      obr=this.orderService.deleteAllOrders()
      obr.subscribe(
        () => {
          this.order.pop,
          this.router.navigateByUrl("/order/orderlist")}
         );
     }
   }


   key : string = "orderId";
   reverse : boolean = false;
   sort(key){
     this.key = key;
     this.reverse = !this.reverse;

   }

}
