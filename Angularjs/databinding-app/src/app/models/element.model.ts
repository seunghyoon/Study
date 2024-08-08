export class Element {
    public type: string;
    public name: string;
    public content: string;

    constructor(type: string, name: string, content: string){
        this.type = type;
        this.name = name;
        this.content = content;
    }
}