import { DatePipe } from "@angular/common";
import { User } from "./user";

export class Order {
    orderId : number;
    userId : number;
    productId:number;
    totalPrice : number;
    totalQuantity : number;
    dispatchDate : DatePipe;
    deliveryDate : DatePipe;
}
