import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  userIdfc : FormControl;
  userPasswordfc : FormControl;
  infoMsg:string;
  errMsg:string;
  loginForm:FormGroup;
  constructor(private userservice: UserService,private router : Router,private routerData:ActivatedRoute) {
    this.userIdfc = new FormControl(null, [Validators.required]);
      this.userPasswordfc = new FormControl(null, [Validators.required]);

      this.loginForm= new FormGroup ({
        userId : this.userIdfc,
        userPassword : this.userPasswordfc,

      });
  }

  ngOnInit(): void {
    this.routerData.queryParams
    .subscribe(
      (params) =>{
        if(params.msg){
          this.infoMsg=params.msg;
        }
      }
    );
 }

  handleSubmit() {
      let obr=null;
      obr = this.userservice.loginadmin(this.loginForm.value.userId,this.loginForm.value.userPassword).subscribe(
      () =>{
         this.router.navigate(['/dashboard1'])
      },
      (err)=>{
        this.errMsg=err.error;
        ;
      }
     );
   }
}
