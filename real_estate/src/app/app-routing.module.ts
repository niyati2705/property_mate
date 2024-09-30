import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LoginReactiveComponent } from './login-reactive/login-reactive.component';
import { PropertyComponent } from './property/property.component';
import { TenantComponent } from './tenant/tenant.component';
import { TenantCreateComponent } from './tenant-create/tenant-create.component';
import { TenantEditComponent } from './tenant-edit/tenant-edit.component';
import { PropertyCreateComponent } from './property-create/property-create.component';
import { PropertyEditComponent } from './property-edit/property-edit.component';
import { LeaseComponent } from './lease/lease.component';

const routes: Routes = [
  { path: 'Home', component: HomeComponent },
  { path: 'myLogin', component: LoginComponent},
  {path:'Login', component: LoginReactiveComponent},

  // { path: '**', component: LoginReactiveComponent},
  

  {path:'Properties', component: PropertyComponent},
  { path: 'AddProperty', component: PropertyCreateComponent},
  { path: 'EditProperty/:id', component: PropertyEditComponent},

  {path:'Tenants', component: TenantComponent},
  { path: 'AddTenant', component: TenantCreateComponent},
  { path: 'EditTenant/:id', component: TenantEditComponent},

  {path:'Leases', component: LeaseComponent},
  // {path:'{id}/Leases', component: TenantLeaseComponent},

  // { path:'', redirectTo:'Products',pathMatch:'full'},

 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }
