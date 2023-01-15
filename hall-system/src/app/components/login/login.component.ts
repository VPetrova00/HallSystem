import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {LoginService} from "../../services/login.service";
import {ILecturerDetails} from "../../interfaces/ILecturerDetails";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup = new FormGroup({
    email: new FormControl(null, [Validators.required, Validators.email]),
    password: new FormControl(null, [Validators.required]),
  });

  constructor(private router: Router, private service: LoginService) {
  }

  login() {
    if (!this.loginForm.valid) {
      return;
    }
    let lecturers: ILecturerDetails[];
    this.service.getAllLecturers().subscribe((data) => {
      lecturers = data;
      lecturers.forEach(({email, password, name, id}) => {
        if (email == this.loginForm.controls['email'].value && password == this.loginForm.controls['password'].value) {
          localStorage.setItem('lecturer', '{"lecturer":"' + name + '"}');
          localStorage.setItem('id', id);
        } else {
          return;
        }
      });
    });

    this.router.navigate(['./pages/homePage']).then(() => {
      window.location.reload();
    });
    return;
  }

  ngOnInit(): void {
  }

}
