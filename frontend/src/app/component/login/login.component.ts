import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'app/service/login.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  constructor(private loginService: LoginService,private router:Router) { }

  login(event: any, user: string, pass: string) {

    event.preventDefault();

    this.loginService.logIn(user, pass).subscribe(
      u => {console.log(u);
        this.router.navigate(['']);
      },
      error => alert('Invalid user or password')
    );
  }

  logOut() {
    this.loginService.logOut().subscribe(
      response => { },
      error => console.log('Error when trying to log out: ' + error)
    );
  }

}
