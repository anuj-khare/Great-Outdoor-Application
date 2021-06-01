import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-producttocart',
  templateUrl: './producttocart.component.html',
  styleUrls: ['./producttocart.component.css']
})
export class ProducttocartComponent implements OnInit {
  productIdfc :FormControl;
 

  productForm : FormGroup;


  userIdfc : FormControl;

  totalQuantityfc : FormControl;

  cartForm : FormGroup;

  infoMsg:string;
  errMsg:string;

  constructor(private productService :ProductService, private router : Router,
    private activatedRoute : ActivatedRoute) {
      this.productIdfc = new FormControl({ value: '', disabled: true });
  
    this.productForm = new FormGroup({
      productId : this.productIdfc,
     
    });
  
    this.userIdfc = new FormControl(null);

    this.totalQuantityfc = new FormControl(null, Validators.required);

    this.cartForm = new FormGroup({
      userId : this.userIdfc,
      totalQuantity : this.totalQuantityfc,
    });

  }

  ngOnInit(): void  {
    let kid = this.activatedRoute.snapshot.params.kid;
    if (kid) {
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
      obr = this.productService.AddproductTocart(this.productIdfc.value,this.cartForm.value).subscribe(
        (data) => {console.log(data),
          this.router.navigateByUrl("/dashboard/cart/cartlist")
        },
        (err)=>{
          this.errMsg=err.error;
        }
      );
 
  }


}
