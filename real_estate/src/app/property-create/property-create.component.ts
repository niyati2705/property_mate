import { Component } from '@angular/core';
import { Property } from '../model/Property';
import { Router } from '@angular/router';
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-property-create',
  templateUrl: './property-create.component.html',
  styleUrl: './property-create.component.css'
})
export class PropertyCreateComponent {
  propertyForm: Property = new Property();
  // router:any;
  constructor(private propertyService:PropertyService, private router: Router){}
  create(){

    this.propertyService.createProperty(this.propertyForm)
    .subscribe({
      next:(data) => {
        
        console.log(" The new property is : "+ this.propertyForm);
        this.router.navigate(["/Properties"])
      },
      error:(err) => {
        console.log(err);
      }
    })
  }
}
