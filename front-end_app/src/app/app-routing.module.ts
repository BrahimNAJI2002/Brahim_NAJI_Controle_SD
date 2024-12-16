import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthGuard} from "./guards/auth.guard";
import {KeynoteComponent} from "./ui/keynote/keynote.component";
import {ConferenceComponent} from "./ui/conference/conference.component";

const routes: Routes = [
  {path : "keynotes", component : KeynoteComponent, canActivate : [AuthGuard], data : {roles :['ADMIN']}},
  {path : "conferences", component : ConferenceComponent, canActivate : [AuthGuard], data : {roles :['ADMIN']}},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
