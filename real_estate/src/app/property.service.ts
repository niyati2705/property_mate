import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Property } from './model/Property';

@Injectable({
  providedIn: 'root'
})
export class PropertyService {

  constructor(private http: HttpClient) { 
  }

//read all
public getAllProperty(): Observable<Property[]> {
   return this.http.get<Property[]>(`http://localhost:4444/api/property`);
}
//create
createProperty(data:Property)
{
 console.log(" Data in create product : "+ data);
 return this.http.post<any>("http://localhost:4444/api/property",data)
 .pipe(map((res:any)=>{
   console.log(res);
   return res;
 }));
}

//update
getById(id: number) {
 return this.http.get<Property>(`http://localhost:4444/api/property/${id}`);
 console.log('');
}

update(payload:Property){
 return this.http.put(`http://localhost:4444/api/property/${payload.pid}`,payload);

}

//delete
deleteProperty(id: number): Observable<any>{
  return this.http.delete(`http://localhost:4444/api/property/${id}`)
 
}
}
