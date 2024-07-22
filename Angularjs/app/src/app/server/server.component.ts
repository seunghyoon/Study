import { Component } from "@angular/core";

@Component({
    selector: 'app-server',
    templateUrl: './server.component.html'
})

export class ServerComponent {
    serverId: Number = 10;
    serverStatus: String = 'offline';
    getServerStatus(){
        return this.serverStatus + "---ggggg";
    }
}