export class Tenant{
    tid!: number;
    tname!:string;
    email! : string;
    taddress!: string;
    phone!: number;
    showLeases?: boolean;
    leases?: any[];
}