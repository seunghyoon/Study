import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  //selector: '[app-servers]',
  //selector: '.app-servers',
  /*
  template: `
    app server
    <app-server></app-server>
    <app-server></app-server>
  `,
  */
  templateUrl: './servers.component.html',
  styleUrl: './servers.component.css'
})
export class ServersComponent {
  allowNewServer: boolean = false;
  serverCreationStatus: string = 'No Server Was Created';
  serverName: string = '';
  constructor() { 
    setTimeout(() => {
      this.allowNewServer = true;
    }, 2000);
  }

  ngOnInit() { 

  }

  onCreateServer() {
    this.serverCreationStatus = 'Server Was Created!';
  }
  onUpdateServerName(event: Event) {
    console.log("event => ", event);
    this.serverName = (<HTMLInputElement>event.target).value;
  }
}
