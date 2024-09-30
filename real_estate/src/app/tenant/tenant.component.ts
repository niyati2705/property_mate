import { Component } from '@angular/core';
import { TenantService } from '../tenant.service';
import { Tenant } from '../model/Tenant';
import { LeaseService } from '../lease.service';

@Component({
  selector: 'app-tenant',
  templateUrl: './tenant.component.html',
  styleUrl: './tenant.component.css'
})
export class TenantComponent {
  public tenants: Tenant[] | undefined;
  constructor(private tenantService: TenantService, private leaseService: LeaseService) { }

  ngOnInit() {

    this.tenantService.getAllTenants().subscribe((res: Tenant[]) => {
      this.tenants = res; //INITIALIZATION
      console.log(' List of tenants:' + this.tenants);
    })

  }
  deleteMyTenant(id: number) {
    console.log("id being deleted: " + id);
    if (confirm('Are you sure you want to delete this Tenant?')) {
      this.tenantService.deleteTenant(id).subscribe(() => {
        this.tenants = this.tenants?.filter(tenant => tenant.tid !== id);
        console.log(`Tenant with id ${id} deleted`);
      });
    }
  }

  // leases for a tenant and toggle display
  toggleLeases(tenant: Tenant) {
    if (tenant.showLeases) {
      tenant.showLeases = false;  // Hide if already visible
    } else {
      // Fetch leases if not already fetched
      if (!tenant.leases) {
        this.leaseService.getLeasesByTenantId(tenant.tid).subscribe((leases) => {
          tenant.leases = leases;  
          tenant.showLeases = true;  
        });
      } else {
        tenant.showLeases = true;
      }
    }
  }

}
