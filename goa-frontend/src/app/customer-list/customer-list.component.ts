import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../model/customer';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})

export class CustomerListComponent implements OnInit {
  customer : Customer[];
  err : string;
  p : number=1;

  constructor(private customerService : CustomerService, private router : Router) { }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(
      (data) => this.customer = data,
      (err) => { console.log (err); this.err = "sorry. unable to retrieve data"}
    );
  }

  delete(customer: number) {
    if (confirm("Are you sure?")) {
      let obr=null;
      obr=this.customerService.delete(customer);
      obr.subscribe(
        () => { this.customer.splice(this.customer.findIndex(e => e.customerId == customer), 1) }
        );

    }
    }


    key : string = "customerId";
    reverse : boolean = false;
    sort(key){
      this.key = key;
      this.reverse = !this.reverse;

    }
}
