import { Component, OnInit } from '@angular/core';
import { Contact } from '../../model/contact';
import { ActivatedRoute, Router } from '../../../../node_modules/@angular/router';
import { ContactService } from '../../service/contact.service';
import { Customer } from '../../model/customer';
import { Packages } from '../../model/packages';
import { formatDate, DatePipe } from '@angular/common';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  contact:Contact;
  isEditing:boolean;
  customer:Customer;
  packages: Packages;
  dateToday:string;


  constructor(
    private activatedRoute:ActivatedRoute,
    private contactService:ContactService,
    private router:Router
  ) { }

  ngOnInit() {
    // this.contact=new Contact();
    // this.isEditing=false;

    // this.activatedRoute.params.subscribe(
    //   (params)=>{
    //     let contactId = params['id'];
    //     if(contactId){
    //       this.contactService.getContactById(contactId).subscribe(
    //         (data)=>{
    //           this.contact=data;
    //           this.isEditing=true;
    //         }
    //       );
    //     }
    //   }
    // );

    this.customer=new Customer();
    this.isEditing=true;
    this.dateToday= new Date().toDateString();

    this.activatedRoute.params.subscribe(
      (params)=>{
        let contactId = params['id'];
        if(contactId){
          this.contactService.getPackageById(contactId).subscribe(
            (data)=>{
              this.packages=data;
              this.isEditing=true;
            }
          );
        }
      }
    );
  }
  //(error)=>{alert("Your email id or mobile number already exist")
  save(){
    // if(this.isEditing){
    //   this.contactService.updateCustomer(this.customer).subscribe(
    //     (data)=>{
    //       this.router.navigateByUrl("/"+this.customer.contactId);
    //     },
    //     (error)=>{alert("Your email id or mobile number already exist");}
    //   );
    // }
    // // else{
      this.customer.title= this.packages.title;
      
      this.customer.date= new Date();
      

      this.contactService.addCustomer(this.customer).subscribe(
        (data)=>{
          this.router.navigateByUrl("/success");
        }
      );
    }
  }

