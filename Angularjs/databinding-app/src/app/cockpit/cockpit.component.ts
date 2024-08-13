import { Component, ElementRef, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrl: './cockpit.component.css'
})
export class CockpitComponent implements OnInit{
  
  @Output('svCreated') serverCreated = new EventEmitter<{serverName: string, serverContent: string}>;
  @Output('bpCreated') bluePrintCreated = new EventEmitter<{serverName: string, serverContent: string}>;
  @ViewChild('serverContentInput') serverContentInput: ElementRef | any;
  //newServerName = '';
  //newServerContent = '';
  

  constructor () {}

  ngOnInit() {
    
  }

  

  onAddServer(nameInput: HTMLInputElement) {
    console.log("serverNameInput ", this.serverContentInput?.nativeElement.value);
    this.serverCreated.emit({
      //serverName: this.newServerName,
      serverName: nameInput.value,
      //serverContent: this.newServerContent
      serverContent: this.serverContentInput.nativeElement.value
    });
    /*
    this.serverElements.push({
      type: 'server',
      name: this.newServerName,
      content: this.newServerContent
    });
    */
  }

  onAddBlueprint(nameInput: HTMLInputElement) {
    console.log("serverNameInput ", nameInput, nameInput.value);
    this.serverContentInput.nativeElement.value ="asdfasdfasdfasdfasdf";
    this.bluePrintCreated.emit({
      //serverName: this.newServerName,
      serverName: nameInput.value,
      //serverContent: this.newServerContent
      serverContent: this.serverContentInput.nativeElement.value
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
