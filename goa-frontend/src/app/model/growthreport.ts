import { DatePipe } from "@angular/common";

export interface Growthreport {
    growthReportId:number;
    currentdate:DatePipe;
    revenue:number;
    amountChange:number;
    percentageGrowth:number;
    colorCode:string;
}
