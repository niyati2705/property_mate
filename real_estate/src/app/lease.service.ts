import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Lease } from './model/Lease';

@Injectable({
  providedIn: 'root'
})
export class LeaseService {


  constructor(private http: HttpClient) { 
  }

//read all
public getAllLease(): Observable<Lease[]> {
   return this.http.get<Lease[]>(`http://localhost:4881/api/lease`);
}
//create
createLease(data:Lease)
{
 console.log(" Data in create lease : "+ data);
 return this.http.post<any>("http://localhost:4881/api/lease",data)
 .pipe(map((res:any)=>{
   console.log(res);
   return res;
 }));
}

//update
getById(id: number) {
 return this.http.get<Lease>(`http://localhost:4881/api/lease/${id}`);
 console.log('');
}

update(payload:Lease){
 return this.http.put(`http://localhost:4881/api/lease/${payload.lid}`,payload);

}

//delete
deleteLease(id: number): Observable<any>{
  return this.http.delete(`http://localhost:4881/api/lease/${id}`)
 
}

  // Method to get leases by tenant ID
  getLeasesByTenantId(tenantId: number): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:4881/api/lease/${tenantId}/leases`);
  }
  
}
