import { Component } from '@angular/core';
import { Tenant } from '../model/Tenant';
import { Router } from '@angular/router';
import { TenantService } from '../tenant.service';


@Component({
  selector: 'app-tenant-create',
  templateUrl: './tenant-create.component.html',
  styleUrl: './tenant-create.component.css'
})
export class TenantCreateComponent {
  tenantForm: Tenant = new Tenant();
  // router:any;
  constructor(private tenantService:TenantService, private router: Router){}
  create(){
    // if (this.tenantForm) {
    //   this.tenantService.createTenant(this.tenantForm)
    //     .subscribe({
    //       next: (data) => {
    //         console.log("The new tenant is: " + this.tenantForm);
    //         this.router.navigate(['/Tenants']);
    //       },
    //       error: (err) => {
    //         console.log(err);
    //       }
    //     });
    //   }
    // }
    // }
    this.tenantService.createTenant(this.tenantForm)
    .subscribe({
      next:(data) => {
        
        console.log(" The new tenant is : "+ this.tenantForm);
        this.router.navigate(["/Tenants"])
      },
      error:(err) => {
        console.log(err);
      }
    })
  }
}
