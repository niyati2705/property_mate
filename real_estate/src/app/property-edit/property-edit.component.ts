import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Property } from '../model/Property';
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-property-edit',
  templateUrl: './property-edit.component.html',
  styleUrl: './property-edit.component.css'
})
export class PropertyEditComponent {

  propertyForm: Property = {
    pid: 0,
    paddress:'',
    ptype:''
  };
  
  constructor(private propertyService:PropertyService,
     private router: Router,
     private route: ActivatedRoute){}

  ngOnInit(): void {
    this.route.paramMap.subscribe((param) => {
      var id = Number(param.get('id')); 
      this.getById(id);
    });

  }

  getById(id: number) {
    this.propertyService.getById(id).subscribe((data) => {
     console.log(data);
      this.propertyForm = data;
      console.log("Property Form: "+ this.propertyForm);
    });
  }

  update() {
    this.propertyService.update(this.propertyForm)
    .subscribe({
      next:(data) => {
        this.router.navigate(["/Properties"]);
      },
      error:(err) => {
        console.log(err);
      }
    })
}
}


