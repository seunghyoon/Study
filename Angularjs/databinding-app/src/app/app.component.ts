import { Component } from '@angular/core';
import { ServerElement } from './models/server-element.model';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  serverElements: ServerElement[] = [{  type: 'server', name: 'Test Server', content: 'Just a test!'}];
  
  onServerAddred(serverData: {serverName: string, serverContent: string}) {
    this.serverElements.push({
      type: 'server',
      name: serverData.serverName,
      content: serverData.serverContent
    });
  }

  onServerAddBlueprint(bluePrintData: {serverName: string, serverContent: string}) {
  
    this.serverElements.push({
      type: 'blueprint',
      name: bluePrintData.serverName,
      content: bluePrintData.serverContent
    });
    
  }
}