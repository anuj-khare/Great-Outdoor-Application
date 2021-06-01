import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../model/customer';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {
  customerIdfc : FormControl;
  customerNamefc : FormControl;
  mobileNofc : FormControl;
  emailfc : FormControl;
  rolefc : FormControl;
  addressIdfc : FormControl;
  buildingNamefc:FormControl;
  streetnofc:FormControl;
  areafc:FormControl;
  cityfc:FormControl;
  statefc:FormControl;
  zipfc:FormControl;

  customerForm : FormGroup;
  isEditing : boolean;

  constructor(private customerService : CustomerService, private router : Router,private activatedRoute:ActivatedRoute) {
    this.customerIdfc = new FormControl(null);
    this.customerNamefc = new FormControl('',[Validators.required]);
    this.mobileNofc = new FormControl('',[Validators.required]);
    this.emailfc = new FormControl('',[Validators.required]);
    this.rolefc = new FormControl('',[Validators.required]);
    this.addressIdfc = new FormControl('',[Validators.required]);
    this.buildingNamefc = new FormControl('',[Validators.required]);
    this.streetnofc = new FormControl('',[Validators.required]);
    this.areafc = new FormControl('',[Validators.required]);
    this.cityfc = new FormControl('',[Validators.required]);
    this.statefc = new FormControl('',[Validators.required]);
    this.zipfc = new FormControl('',[Validators.required]);

    this.customerForm = new FormGroup({
      customerId : this.customerIdfc,
      customerName : this.customerNamefc,
      mobileNo : this.mobileNofc,
      email : this.emailfc,
      role : this.rolefc,
      addressId : this.addressIdfc,
      buildingName: this.buildingNamefc,
      streetNo: this.streetnofc,
      area:this.areafc,
      state:this.statefc,
      city:this.cityfc,
      zip:this.zipfc
    });
    this.isEditing = false;

  }

  ngOnInit(): void {
    let cid = this.activatedRoute.snapshot.params.cid;
  if (cid) {
    this.isEditing = true;
    this.customerService.getById(cid).subscribe(
      (data) => {
        this.customerForm.setValue( {
          customerId : data.customerId,
          customerName : data.customerName,
          mobileNo :data.mobileNo,
            email :data.email,
            role:data.role,
            addressId:data.address.addressId,
            buildingName:data.address.buildingName,
             streetNo :data.address.streetNo,
             area :data.address.area,
            city :data.address.city,
            state :data.address.state,
            zip:data.address.zip  
        });
      } 
      
    //   (data) => this.customerForm.setValue(data)
    // );
    );
  }
  }

  handleSubmit() {
    let customer : Customer = {
      address:{
        addressId : this.customerForm.value.addressId,
        buildingName : this.customerForm.value.buildingName,
        streetNo:this.customerForm.value.streetNo,
        area : this.customerForm.value.area,
        city : this.customerForm.value.city,
        state : this.customerForm.value.state,
        zip : this.customerForm.value.zip
      },
      customerId : this.customerForm.value.customerId,
      customerName : this.customerForm.value.customerName,
      mobileNo : this.customerForm.value.mobileNo,
      email : this.customerForm.value.email,
      role:this.customerForm.value.role
    };
    let obr=null;
    if (this.isEditing) {
      obr = this.customerService.update(customer);
    } else {
    obr = this.customerService.add(customer);
    }
    obr.subscribe(
      (data) => this.router.navigateByUrl("dashboard/customer/customerlist")
    );
  }

}
