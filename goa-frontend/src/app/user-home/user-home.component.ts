import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from '../model/order';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

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
      obr = this.userservice.loginUser(this.loginForm.value.userId,this.loginForm.value.userPassword).subscribe(
      (data) =>{
         this.router.navigate(['/dashboard'])

              },
      (err)=>{
        this.errMsg=err.error;

      }
     );
   }
}
