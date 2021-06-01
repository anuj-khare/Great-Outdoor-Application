import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { GrowthreportService } from '../service/growthreport.service';

@Component({
  selector: 'app-growthreport-form',
  templateUrl: './growthreport-form.component.html',
  styleUrls: ['./growthreport-form.component.css']
})
export class GrowthreportFormComponent implements OnInit {
  message: string;

  GrowthreportIdfc : FormControl;
  currentdatefc : FormControl;
  revenuefc : FormControl;
  amountChangefc : FormControl;
  percentageGrowthfc : FormControl;
  colorCodefc : FormControl;


  growthForm : FormGroup;


  currentDate = new Date();
  constructor(private growthreportService: GrowthreportService,private router : Router,private activatedRoute : ActivatedRoute) { 
    this.GrowthreportIdfc = new FormControl(null);
    this.currentdatefc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
    this.revenuefc = new FormControl(null, [Validators.required,  Validators.minLength(3)]);
    this.amountChangefc = new FormControl(null,[ Validators.required,Validators.minLength(3)]);
    this.percentageGrowthfc = new FormControl(null, [Validators.required,  Validators.minLength(3)]);
    this.colorCodefc = new FormControl(null,[ Validators.required,Validators.minLength(3)]);


    this.growthForm = new FormGroup({
      growthReportId:this.GrowthreportIdfc,
      currentdate:this.currentdatefc,
      revenue:this.revenuefc,
      amountChange:this.amountChangefc,
      percentageGrowth:this.percentageGrowthfc,
      colorCode:this.colorCodefc,
    });
  }



  ngOnInit(): void {
  }

  handleSubmit() {
    let obr=null;
    obr = this.growthreportService.add(this.growthForm.value);
    obr.subscribe(
      (data) => this.router.navigateByUrl("dashboard1/growth/growthlist")
    );
  }

}
