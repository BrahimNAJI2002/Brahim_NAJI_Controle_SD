import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthGuard} from "./guards/auth.guard";
import {ProductComponent} from "./ui/product/product.component";

const routes: Routes = [
  {path : "products", component : ProductComponent, canActivate : [AuthGuard], data : {roles :['ADMIN']}},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
