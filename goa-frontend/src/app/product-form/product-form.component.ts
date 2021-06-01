import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {
  productIdfc :FormControl;
  productNamefc : FormControl;
  pricefc : FormControl;
  imagefc : FormControl;
  colorfc : FormControl;
  categoryfc : FormControl;
  quantityfc : FormControl;
  manufacturerfc : FormControl;
  specificationfc : FormControl;

  productForm : FormGroup;
  isEditing : boolean;
  constructor(private productService :ProductService, private router : Router,
    private activatedRoute : ActivatedRoute) {
      this.productIdfc = new FormControl(null);
      this.productNamefc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
      this.pricefc = new FormControl (null, [Validators.required, Validators.minLength(3)]);
      this.imagefc = new FormControl  (null, [Validators.required, Validators.minLength(3)]);
      this.colorfc = new FormControl (null, [Validators.required, Validators.minLength(3)]);
      this.categoryfc = new FormControl (null, [Validators.required, Validators.minLength(3)]);
    this.quantityfc = new FormControl (null, [Validators.required, Validators.minLength(3)]);
    this.manufacturerfc = new FormControl (null, [Validators.required, Validators.minLength(3)]);
    this.specificationfc = new FormControl (null, [Validators.required, Validators.minLength(3)]);

    this.productForm = new FormGroup({
      productId : this.productIdfc,
      productName : this.productNamefc,
      price : this.pricefc,
      image : this.imagefc,
      color : this.colorfc,
      category : this.categoryfc,
      quantity : this. quantityfc,
      manufacturer : this. manufacturerfc,
      specification : this. specificationfc,
    });
    this.isEditing = false;
  }

ngOnInit(): void {
  let pid = this.activatedRoute.snapshot.params.pid;
  if (pid) {
    this.isEditing = true;
    this.productService.getById(pid).subscribe(
      (data) => this.productForm.setValue(data)
    );
  }
}

handleSubmit() {
  let obr=null;
  if (this.isEditing) {
    obr = this.productService.update(this.productForm.value);
  } else {
  obr = this.productService.add(this.productForm.value);
  }
  obr.subscribe(
    (data) => this.router.navigateByUrl("/dashboard1/product1")
  );
}
}
