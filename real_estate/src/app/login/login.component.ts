import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
/* For ---Template */
loginSubmit(loginForm:any){
  console.log(loginForm);
}

}
