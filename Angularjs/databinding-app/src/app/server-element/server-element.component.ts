import { Component, OnInit, Input } from '@angular/core';
import { ServerElement } from '../models/server-element.model';

@Component({
  selector: 'app-server-element',
  templateUrl: './server-element.component.html',
  styleUrl: './server-element.component.css'
})
export class ServerElementComponent implements OnInit{
  @Input('srvElement') element: ServerElement = {  type: '', name: '', content: ''};
  constructor () {}

  ngOnInit() {
    
  }
}
