import { Pipe, PipeTransform } from '@angular/core';
import { Contact } from '../model/contact';

@Pipe({
  name: 'bornToday'
})
export class BornTodayPipe implements PipeTransform {

  transform(contacts: Contact[]):Contact[] {
    let today=new Date();
    return contacts.filter(c => {
      let dob1 = new Date(c.dob);
      return dob1.getDate()==today.getDate() &&
            dob1.getMonth()==today.getMonth();
    });
  }

}
