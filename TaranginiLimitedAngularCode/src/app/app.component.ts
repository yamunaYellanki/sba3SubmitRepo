import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title : string;
  logoUrl: string;
  field:string="emailId";
  srchValue:string="";
  tllogo:string;
  constructor(
    private router:Router
  ){
    this.title="Tarangini Limited";
    this.logoUrl="/assets/Images/adbLogo.png";
    this.tllogo="/assets?Images/TL.png"
  }

  doSearch(){
    this.router.navigate(["/listContacts"],{queryParams:{field:this.field,srchValue:this.srchValue}});
  }

  doChangeField(field,ele){
    this.field=field;
    this.srchValue="";
    switch(field){
      case 'net': ele.placeholder="Net speed";ele.type="number"; break;
      case 'maxusage': ele.placeholder="FUP"; ele.type="number";break;
      case 'cost': ele.placeholder="Cost"; ele.type="number";break;
    }
  }
}
