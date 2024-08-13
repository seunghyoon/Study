import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrl: './cockpit.component.css'
})
export class CockpitComponent implements OnInit{
  
  @Output('svCreated') serverCreated = new EventEmitter<{serverName: string, serverContent: string}>;
  @Output('bpCreated') bluePrintCreated = new EventEmitter<{serverName: string, serverContent: string}>;
  
  //newServerName = '';
  newServerContent = '';
  
  constructor () {}

  ngOnInit() {
    
  }

  

  onAddServer(serverNameInput: any) {
    console.log("serverNameInput ", serverNameInput, serverNameInput.value);
    this.serverCreated.emit({
      //serverName: this.newServerName,
      serverName: serverNameInput.value,
      serverContent: this.newServerContent
    });
    /*
    this.serverElements.push({
      type: 'server',
      name: this.newServerName,
      content: this.newServerContent
    });
    */
  }

  onAddBlueprint(serverNameInput: any) {
    console.log("serverNameInput ", serverNameInput, serverNameInput.value);

    this.bluePrintCreated.emit({
      //serverName: this.newServerName,
      serverName: serverNameInput.value,
      serverContent: this.newServerContent
    });
    /*
    this.serverElements.push({
      type: 'blueprint',
      name: this.newServerName,
      content: this.newServerContent
    });
    */
  }

}
