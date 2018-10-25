import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Contact } from '../model/contact';
import { Packages } from '../model/packages';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  baseUrl: string;
  baseurl1:string;
  constructor(private http: Http) {
    this.baseUrl = "http://localhost:5252/Packages";
    this.baseurl1= "http://localhost:5252/Customer";
  }

  getBaseUrlById(id: number): string {
    return this.baseUrl + "/" + id;
  }

  getBasUrlById(id: string): string {
    return this.baseUrl + "/" + id;
  }

  getSearchUrl(field: string, value: string): string {

    return this.baseUrl + "/" + field + "/" + value;
  }
  getSearchUrl1(field: string, value: string): string {
    
    return this.baseUrl + "/" + field + "/" + value;
  }

  getJsonContentTypeHeader(): RequestOptions {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }

  getAllPackages(): Observable<Packages[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data.json())
    );
  }

  searchPackage(field: string, value:string): Observable<Packages[]> {
    return this.http.get(this.getSearchUrl1(field,value)).pipe(
      map(data => data.json())
    );
  }

  searchContacts(field: string, value: string): Observable<Contact[]> {
    return this.http.get(this.getSearchUrl(field,value)).pipe(
      map(data => data.json())
    );
  }


  getContactById(id: number): Observable<Contact> {
    return this.http.get(this.getBaseUrlById(id)).pipe(
      map(data => data.json())
    );
  }

  getPackageById(id: string): Observable<Packages> {
    return this.http.get(this.getBasUrlById(id)).pipe(
      map(data => data.json())
    );
  }


  deleteContactById(id: number): Observable<Response> {
    return this.http.delete(this.getBaseUrlById(id));
  }

  addContact(contact: Contact): Observable<Contact> {
    return this.http.post(this.baseUrl, JSON.stringify(contact), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }

  getJsonContentTypeHeader1(): RequestOptions {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }



  addCustomer(customer: Customer): Observable<Customer> {
    return this.http.post(this.baseurl1, JSON.stringify(customer), this.getJsonContentTypeHeader1()).pipe(
      map(data => data.json())
    );
  }

  updateContact(contact: Contact): Observable<Contact> {
    return this.http.put(this.baseUrl, JSON.stringify(contact), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }

}
