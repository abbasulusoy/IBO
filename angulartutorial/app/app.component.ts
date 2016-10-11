import { Component, OnInit
     } from '@angular/core';
     
@Component({
  selector: 'my-app',
  template: ` 
  Test {{contacts[name]}} mein list: {{liste[1]}} 
  <input 
    type="text"
    (keyup)="onKeyUp()"
    (input)="color=$event.target.value"
    [style.background-color]="color"
    >
`
    
})
export class AppComponent {

    liste : Array<string>;
    public contacts:{name: "abbas",nachname:"ulusoy",phone :"12321313",email:"abbasulusoy@hotmail.com"};
    showDetail :boolean = false;

    public color: string;
    onKeyUp() {
        console.log('keyup: ' +         
        this.color)
    }


    AppComponent() {
        this.liste.push("Inci");
        this.liste.push("Abbas");
        this.liste.push("Murat");
        this.liste.push("Döndu");
        this.liste.push("Mustafa");
        this.liste.push("Nazmiye");

    }
    onSelect() {
      this.showDetail=true;
    }
 }
