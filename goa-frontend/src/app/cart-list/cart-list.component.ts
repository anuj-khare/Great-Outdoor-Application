
import { Component, OnInit } from '@angular/core';
import { Cart } from '../model/cart';
import { Order } from '../model/order';
import { User } from '../model/user';
import { CartService } from '../service/cart.service';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})

export class CartListComponent {

  cart: Cart[];
  err: string;
order:Order;
cart1:Cart;
myDate = new Date();
user:User;
p : number=1;
  constructor(private cartService: CartService,private orderservice:OrderService) { }

  ngOnInit(cartId: number) {
    this.cartService.findCartlist().subscribe(
      (data) => this.cart = data,
      (err) => { console.log(err); this.err = "sorry. unable to retrieve data" }
    );
  }

  delete(userId: number) {
    if (confirm("Are you sure?")) {
      this.cartService.deleteCartlist(userId).subscribe(
        () => { this.cart.splice(this.cart.findIndex(c => c.userId == userId), 1) }
      );
    }
  }

  key : string = "cartId";
  reverse : boolean = false;
  sort(key){
    this.key = key;
    this.reverse = !this.reverse;

  }
}


