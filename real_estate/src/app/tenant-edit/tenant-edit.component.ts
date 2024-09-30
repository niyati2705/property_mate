import { Component } from '@angular/core';
import { Tenant } from '../model/Tenant';
import { TenantService } from '../tenant.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-tenant-edit',
  templateUrl: './tenant-edit.component.html',
  styleUrl: './tenant-edit.component.css'
})
export class TenantEditComponent {
  tenantForm: Tenant = {
    tid: 0,
    tname:'',
    email:'',
    taddress:'',
    phone: 0
  };
  
  constructor(private tenantService:TenantService,
     private router: Router,
     private route: ActivatedRoute){}

  ngOnInit(): void {
    this.route.paramMap.subscribe((param) => {
      //editt:101 = @Path Varaible
      var id = Number(param.get('id')); // Read the tenant id from route
      this.getById(id);
      //this.router.navigate(["/Products"]);
    });

  }

  getById(id: number) {
    this.tenantService.getById(id).subscribe((data) => {
     console.log(data);
      this.tenantForm = data;
      console.log("Tenant Form: "+ this.tenantForm);
    });
  }

  update() {
    this.tenantService.update(this.tenantForm)
    .subscribe({
      next:(data) => {
        this.router.navigate(["/Tenants"]);
      },
      error:(err) => {
        console.log(err);
      }
    })
}
}
