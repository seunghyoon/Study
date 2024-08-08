import { Component } from '@angular/core';
import { Element } from './models/element.model';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  serverElements:Element[] = [];
  newServerName = '';
  newServerContent = '';
  
  onAddServer() {

   
    this.serverElements.push(new Element('server', this.newServerName, this.newServerContent));
  }

  onAddBlueprint() {
    this.serverElements.push(new Element('blueprint', this.newServerName, this.newServerContent));
  }
}
