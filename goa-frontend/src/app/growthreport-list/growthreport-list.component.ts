import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Growthreport } from '../model/growthreport';
import { GrowthreportService } from '../service/growthreport.service';

@Component({
  selector: 'app-growthreport-list',
  templateUrl: './growthreport-list.component.html',
  styleUrls: ['./growthreport-list.component.css']
})
export class GrowthreportListComponent implements OnInit {
  growth : Growthreport[];
  err : string;
  p : number=1;
  constructor(private growthService : GrowthreportService,private router : Router) { }

  ngOnInit(): void {
    this.growthService.getAll().subscribe(
      (data) => this.growth = data,
      (err) => { console.log (err); this.err = "sorry. unable to retrieve data"}
    );
  }

  delete(growthReportId: number) {
    if (confirm("Are you sure?")) {
      this.growthService.deleteById(growthReportId).subscribe(
        () => { this.growth.splice(this.growth.findIndex(e => e.growthReportId == growthReportId), 1) }
      );
    }
  }


  deleteall() {
    if (confirm("Are you sure?it will delete all Growth Report")) {
      let obr=null;
      obr=this.growthService.deleteAll();
      obr.subscribe(
        (data) => {
          this.growth.pop,
          this.router.navigate(["dashboard1/growth/growthlist"])
        }
      );
    }
  }


  key : string = "cartId";
  reverse : boolean = false;
  sort(key){
    this.key = key;
    this.reverse = !this.reverse;

  }
}
