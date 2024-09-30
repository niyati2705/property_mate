import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login-reactive',
  templateUrl: './login-reactive.component.html',
  styleUrl: './login-reactive.component.css'
})
export class LoginReactiveComponent {

  loginForm = new FormGroup ({
    user : new FormControl (null,Validators.required),
    pass : new FormControl (null,Validators.required)
})
loginUser()
{console.log(this.loginForm.value);}


get user()
{ return  this.loginForm.get('user');}

get pass()
{
return this.loginForm.get('pass');
}
}
