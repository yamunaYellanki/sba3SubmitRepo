import { Component, OnInit } from '@angular/core';
import { ContactService } from '../../service/contact.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-successpage',
  templateUrl: './successpage.component.html',
  styleUrls: ['./successpage.component.css']
})
export class SuccesspageComponent implements OnInit {
  successlogo:string;
  dateToday:string;
  constructor(private contactService:ContactService
    , private activatedRoute : ActivatedRoute ) {
    this.successlogo="/assets/Images/success.png"
    this.dateToday=new Date().toString();
   }

  ngOnInit() {
  
  }

}
