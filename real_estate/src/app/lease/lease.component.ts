import { Component } from '@angular/core';
import { Lease } from '../model/Lease';
import { LeaseService } from '../lease.service';

@Component({
  selector: 'app-lease',
  templateUrl: './lease.component.html',
  styleUrl: './lease.component.css'
})
export class LeaseComponent {

  public leases: Lease[] | undefined;
  constructor(private leaseService: LeaseService){}

  ngOnInit() {

    this.leaseService.getAllLease().subscribe((res: Lease[]) => {
          this.leases = res; //INITIALIZATION
          console.log(' List of properties:'+this.leases);
    } )

  }
  deleteMyLease(id: number) {
    console.log("id being deleted: "+id);
    if (confirm('Are you sure you want to delete this Lease?')) {
      this.leaseService.deleteLease(id).subscribe(() => {
        this.leases = this.leases?.filter(lease => lease.lid !== id);
        console.log(`Lease with id ${id} deleted`);
      });
    }
  }   
}

