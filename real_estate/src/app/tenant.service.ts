import { Injectable } from '@angular/core';
import { Tenant } from './model/Tenant';
import { map, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TenantService {
  constructor(private http: HttpClient) { 
  }

//read all
public getAllTenants(): Observable<Tenant[]> {
   return this.http.get<Tenant[]>(`http://localhost:4554/api/tenant`);
}
//create
createTenant(data:Tenant)
{
 console.log(" Data in create product : "+ data);
 return this.http.post<any>("http://localhost:4554/api/tenant",data)
 .pipe(map((res:any)=>{
   console.log(res);
   return res;
 }));
}

//update
getById(id: number) {
 return this.http.get<Tenant>(`http://localhost:4554/api/tenant/${id}`);
 console.log('');
}

update(payload:Tenant){
 return this.http.put(`http://localhost:4554/api/tenant/${payload.tid}`,payload);

}

//delete
deleteTenant(id: number): Observable<any>{
  return this.http.delete(`http://localhost:4554/api/tenant/${id}`)
 
}

//get leases for tenant
getLeasesByTenantId(tenantId: number): Observable<any[]> {
  return this.http.get<any[]>(`http://localhost:4554/api/lease/${tenantId}/leases`);
}
}
