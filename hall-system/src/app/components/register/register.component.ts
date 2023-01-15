import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomValidators} from "../custom-validator";
import {Router} from "@angular/router";
import {ILecturerDetails, Lecturer} from "../../interfaces/ILecturerDetails";
import {RegistrationService} from "../../services/registration.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm = new FormGroup({
      email: new FormControl(null, [Validators.required, Validators.email]),
      username: new FormControl(null, [Validators.required]),
      // firstname: new FormControl(null, [Validators.required]),
      // lastname: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required]),
      passwordConfirm: new FormControl(null, [Validators.required])
    },
    // add custom Validators to the form, to make sure that password and passwordConfirm are equal
    { validators: CustomValidators.passwordsMatching }
  )

  constructor(private router: Router, private registrationService: RegistrationService) {}


  register(data:any) {
    if (!this.registerForm.valid) {
      return;
    }
    if(data) {
      let lecturer = new Lecturer(data.username, data.email, data.password);
      this.registrationService.addLecturer(lecturer);
      this.router.navigate(['login']);
    }
  }

  ngOnInit(): void {
  }

}
