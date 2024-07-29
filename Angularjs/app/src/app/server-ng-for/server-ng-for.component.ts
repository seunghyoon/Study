import { Component } from '@angular/core';

@Component({
  selector: 'app-server-ng-for',
  templateUrl: './server-ng-for.component.html',
  styleUrl: './server-ng-for.component.css'
})
export class ServerNgForComponent {
  showSecret: boolean = false;
  //log: number[] = [];
  log: string[] = [];

  onToggleDetails() {
    this.showSecret = !this.showSecret;
    /*
    let totTalCnt = this.log.length + 1;
    console.log(totTalCnt);
    this.log.push(totTalCnt);
    */
    this.log.push(new Date().toString());
    console.log(this.showSecret , this.log);
  }

}


