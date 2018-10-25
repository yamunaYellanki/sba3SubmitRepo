import { Component, OnInit } from '@angular/core';
import { Contact } from '../../model/contact';
import { ContactService } from '../../service/contact.service';
import { ActivatedRoute } from '@angular/router';
import { Packages } from '../../model/packages';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  title: string;
  logoUrl: string;
  ladyLogo: string;
  gentLogo: string;
  birthLogo:string;
  contacts: Contact[];
  packages: Packages[];
  msg : string;
  constructor(private contactService:ContactService,
    private activatedRoute:ActivatedRoute) {
    this.title = "Tarangini Limited";
    this.logoUrl = "/assets/Images/adbLogo.png"; 
    this.ladyLogo = "/assets/Images/lady.png";
    this.gentLogo = "/assets/Images/male.png";
    this.birthLogo = "/assets/Images/birthday.png";
  }

  ngOnInit() {
    this.contactService.getAllPackages().subscribe(
      (data) => this.packages = data
    );
    this.activatedRoute.queryParams.subscribe(
      (params)=>{
        let contactId=params['id'];
        let operation=params['opt'];
        if(contactId && operation){
          this.msg = "Contact # "+contactId + " is successfully "+
          (operation=='d'?'Deleted':(operation=='a'?'added':'updated'));
          
        }else{
          this.msg=undefined;
        }
      }
    );
  }
}
