import { Component } from '@angular/core';
import { Property } from '../model/Property';
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-property',
  templateUrl: './property.component.html',
  styleUrl: './property.component.css'
})
export class PropertyComponent {
  public properties: Property[] | undefined;
  constructor(private propertyService: PropertyService){}

  ngOnInit() {

    this.propertyService.getAllProperty().subscribe((res: Property[]) => {
          this.properties = res; //INITIALIZATION
          console.log(' List of properties:'+this.properties);
    } )

  }
  deleteMyProperty(id: number) {
    console.log("id being deleted: "+id);
    if (confirm('Are you sure you want to delete this Property?')) {
      this.propertyService.deleteProperty(id).subscribe(() => {
        this.properties = this.properties?.filter(property => property.pid !== id);
        console.log(`Property with id ${id} deleted`);
      });
    }
  }   
}
