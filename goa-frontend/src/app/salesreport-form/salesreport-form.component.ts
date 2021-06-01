import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { SalesreportService } from '../service/salesreport.service';

@Component({
  selector: 'app-salesreport-form',
  templateUrl: './salesreport-form.component.html',
  styleUrls: ['./salesreport-form.component.css']
})
export class SalesreportFormComponent implements OnInit {
  salesReportIdfc : FormControl;
  productIdfc : FormControl;
  productNamefc : FormControl;
  quantitySoldfc : FormControl;
  totalSalefc : FormControl;
  
  SalesReportForm : FormGroup;
  isEditing:boolean;
  constructor(private salesreportService : SalesreportService , private activatedRoute : ActivatedRoute,private router : Router) { 
    this.salesReportIdfc = new FormControl();
    this.productIdfc = new FormControl(null,Validators.required);
    this.productNamefc = new FormControl(null,Validators.required);
    this.quantitySoldfc = new FormControl(null,Validators.required);
    this.totalSalefc = new FormControl(null,Validators.required);

    this.SalesReportForm = new FormGroup({
      salesReportId : this.salesReportIdfc,
      productId : this.productIdfc,
      productName : this.productNamefc,
      quantitySold : this.quantitySoldfc,
      totalSale : this.totalSalefc
    });
    this.isEditing = false;
  }

  ngOnInit(): void {
    let sid = this.activatedRoute.snapshot.params.sid;
    if (sid) {
      this.isEditing = true;
    this.salesreportService.getById(sid).subscribe(
      (data) => this.SalesReportForm.setValue(data)
    );
  }
  }
  handleSubmit(){
    let obr = null;
     if (this.isEditing) {
   obr = this.salesreportService.updateQuantity(this.SalesReportForm.value);
     }
  obr.subscribe(
    (data) => this.router.navigateByUrl("dashboard1/sales/saleslist")
  );
     
}

}
