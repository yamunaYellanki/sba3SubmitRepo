import { Component, OnInit } from '@angular/core';
import { Contact } from '../../model/contact';
import { ContactService } from '../../service/contact.service';
import { ActivatedRoute } from '@angular/router';
import {Packages} from '../../model/packages';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent implements OnInit {

  packages:Packages[];
  
  ladyLogo:string;
  gentLogo:string;
  wifiLogo:String;

  constructor(
    private contactService:ContactService
, private activatedRoute : ActivatedRoute  ) {
    this.ladyLogo="/assets/Images/lady.png";
    this.gentLogo="/assets/Images/male.png";
    this.wifiLogo="/assets/Images/wifi.png"
   }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe(
      (params) =>{
        let field = params['field'];
        let srchValue = params['srchValue'];

        console.log(field +":"+srchValue);

        if(field && srchValue){
          this.contactService.searchPackage(field,srchValue).subscribe(
            (data) => this.packages=data,
            (err)=>this.packages=undefined
          );
        }
        else{
          this.contactService.getAllPackages().subscribe(
            (data) => this.packages=data,
            (err)=>this.packages=undefined
          );
        }
      }
    );
    }
      
    
    
  }
  

