import { MyReservationsComponent } from './components/my-reservations/my-reservations.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from './components/login/login.component'
import {RegisterComponent} from "./components/register/register.component";
import {HomePageComponent} from "./components/pages/home-page/home-page.component";
import {AdditionalInfoComponent} from "./components/additional-info/additional-info.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'pages/homePage', component: HomePageComponent },
  { path: 'pages/myReservations', component: MyReservationsComponent },
  { path: 'hall/details', component: AdditionalInfoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
