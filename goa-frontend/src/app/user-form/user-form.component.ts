import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  message: string;

  userIdfc : FormControl;
  userNamefc : FormControl;
  userTypefc : FormControl;
  userPasswordfc : FormControl;

  userForm : FormGroup;
  scope = true;
  infoMsg:string;
  errMsg:string;
  constructor(private userservice: UserService,private router : Router,private activatedRoute : ActivatedRoute) { 
    this.userIdfc = new FormControl(null,[Validators.required,Validators.minLength(3)]);
    this.userNamefc = new FormControl(null, [Validators.required, Validators.minLength(4)]);
    this.userTypefc = new FormControl(null, [Validators.required]),
    this.userPasswordfc = new FormControl(null,[ Validators.required,Validators.minLength(4)]);
  
    this.userForm = new FormGroup({
      userId : this.userIdfc,
      userName : this.userNamefc,
      userType : this.userTypefc,
      userPassword : this.userPasswordfc
    });
    }

  ngOnInit(): void {
    this.activatedRoute.queryParams
    .subscribe(
      (params) =>{
        if(params.msg){
          // this.infoMsg=params.msg;
          this.infoMsg="you have registered with userId:"+this.userIdfc+"and Password "+this.userPasswordfc;
        }
      }
    );
  }

  handleSubmit() {
    let obr=null;
    obr = this.userservice.addUser(this.userForm.value);
    obr.subscribe(
      (data) => {
        this.router.navigateByUrl("/applogin"),
        this.infoMsg
      },
      (err)=>{
        this.errMsg=err.error;
        ;
      }
    );
  }

}
