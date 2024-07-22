import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  //styleUrls: ['./app.component.css']
  styles: [`
    h3 {
      color: dodgerblue;
      font-size: 30px;
    }  
  `]
})
export class AppComponent {
  name = 'Max';
}
