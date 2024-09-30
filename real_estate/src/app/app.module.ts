import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { LoginReactiveComponent } from './login-reactive/login-reactive.component';
import { HttpClientModule } from '@angular/common/http';
import { PropertyComponent } from './property/property.component';
import { TenantComponent } from './tenant/tenant.component';
import { TenantCreateComponent } from './tenant-create/tenant-create.component';
import { TenantEditComponent } from './tenant-edit/tenant-edit.component';
import { TenantService } from './tenant.service';
import { PropertyService } from './property.service';
import { PropertyCreateComponent } from './property-create/property-create.component';
import { PropertyEditComponent } from './property-edit/property-edit.component';
import { LeaseComponent } from './lease/lease.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    LoginReactiveComponent,
    PropertyComponent,
    TenantComponent,
    TenantCreateComponent,
    TenantEditComponent,
    PropertyCreateComponent,
    PropertyEditComponent,
    LeaseComponent,
  
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
    
  ],
  providers: [TenantService, PropertyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
