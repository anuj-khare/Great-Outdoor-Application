import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-producttoorder',
  templateUrl: './producttoorder.component.html',
  styleUrls: ['./producttoorder.component.css']
})
export class ProducttoorderComponent implements OnInit {
  productIdfc :FormControl;
  productForm : FormGroup;

  orderIdfc : FormControl;
  totalQuantityfc : FormControl;
  infoMsg:string;
  errMsg:string;
  orderForm : FormGroup;
  constructor(private productService :ProductService, private router : Router,
    private activatedRoute : ActivatedRoute) { 
      this.productIdfc = new FormControl({ value: '', disabled: true });

      this.orderIdfc = new FormControl(null);
      this.totalQuantityfc = new FormControl(null, Validators.required);

      this.productForm = new FormGroup({
        productId : this.productIdfc,
      });
      
      this.orderForm = new FormGroup({
        userId : this.orderIdfc,
        totalQuantity : this.totalQuantityfc,
      });
    }

  ngOnInit(): void {
    let kid = this.activatedRoute.snapshot.params.kid;
    if (kid) {
     // this.isEditing = true;
      this.productService.getById(kid).subscribe(
        (data) => this.productForm.setValue(data)
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


  handleSubmit(){
    let obr=null;
    //if (this.isEditing) {
      obr = this.productService.AddproductToorder(this.productIdfc.value,this.orderForm.value).subscribe(
        (data) => {console.log(data),
          this.router.navigateByUrl("/dashboard/order/orderlist")
        },
        (err)=>{
          this.errMsg=err.error;
        }
      );
      }
}
