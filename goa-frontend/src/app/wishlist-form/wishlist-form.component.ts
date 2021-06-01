import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { WishlistService } from '../service/wishlist.service';

@Component({
  selector: 'app-wishlist-form',
  templateUrl: './wishlist-form.component.html',
  styleUrls: ['./wishlist-form.component.css']
})
export class WishlistFormComponent implements OnInit {
  wishListIdfc : FormControl ;
  userIdfc : FormControl ;
  productIdfc : FormControl ;

  wishListForm : FormGroup ; 
  
  isAddById : boolean ;
  uid :string;
  wid :  number;
  
  
  constructor(private wishlistervice : WishlistService ,private activatedRoute : ActivatedRoute ,private router : Router) { 
    this.wishListIdfc = new FormControl(null);
    this.userIdfc = new FormControl(null, Validators.required);
    this.productIdfc = new FormControl(null, Validators.required);

    this.wishListForm = new FormGroup({
      wishlistId : this.wishListIdfc,
      userId : this.userIdfc ,
      productId : this.productIdfc
    })
    this.isAddById = false ;
  }

  ngOnInit(): void {
  //   this.uid = this.activatedRoute.snapshot.params.uid
  //   if (this.uid){
  //   this.wid = this.activatedRoute.snapshot.params.wid ;
  //   if (this.wid){
  //     this.isAddById = true ;
  //     // this.wishlistervice.addById(this.uid , this.wid ).subscribe(
  //     //   (data) => this.wishListForm.setValue(data)
  //     //);
  //   }
  // } 
    
  }
  
  handleSubmit(){
    let obr = null;
   // if(this.isAddById){
      obr = this.wishlistervice.add(this.wishListForm.value);
    //}else{
     // obr = this.wishlistervice.add(this.wishListForm.value);
    //}
    obr.subscribe(
       (data) => this.router.navigateByUrl("/dashboard/wish/wishlist")
    );
  }


}
