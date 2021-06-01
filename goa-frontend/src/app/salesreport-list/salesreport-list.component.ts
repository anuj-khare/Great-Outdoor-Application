import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Salesreport } from '../model/salesreport';
import { SalesreportService } from '../service/salesreport.service';

@Component({
  selector: 'app-salesreport-list',
  templateUrl: './salesreport-list.component.html',
  styleUrls: ['./salesreport-list.component.css']
})
export class SalesreportListComponent implements OnInit {
  sales : Salesreport[];
  err : string ;
  constructor(private salesService : SalesreportService,private router:Router){

  }
  ngOnInit(): void {
    this.salesService.getAll().subscribe(
      (data) => this.sales = data,
      (err) => { this.err = "sorry , data cannot be fetched"}
    );
  }
  delete(sid : number){
    if(confirm("Are you sure?")){
      this.salesService.deleteById(sid).subscribe(
        () =>{ this.sales.splice(this.sales.findIndex(sr => sr.salesReportId == sid),1)}
      );
    }
  }

  deleteall() {
    if (confirm("Are you sure?")) {
      let obr=null;
      obr=this.salesService.deleteAll();
      obr.subscribe(
        () => {
          this.sales.pop
          this.router.navigateByUrl("/dashboard1/sales/saleslist")
        }
      );
    }
  }

  
  

}
