import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers', // 표준?
  //selector: '[app-servers]', //attr 속성
  //selector: '.app-servers', // css class 속성
  /*
  template: `
    app server
    <app-server></app-server>
    <app-server></app-server>
  `,
  */ // template url 대신 간단한 경우 사용 편의성 있음
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
    console.log("onCreateServer this.serverCreationStatus => ", this.serverCreationStatus);
  }
  onUpdateServerName(event: Event) {
    console.log("event => ", event);
    this.serverName = (<HTMLInputElement>event.target).value;
    console.log("this.serverName => ", this.serverName);
  }
}
