"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var AppComponent = (function () {
    function AppComponent() {
        this.showDetail = false;
    }
    AppComponent.prototype.onKeyUp = function () {
        console.log('keyup: ' +
            this.color);
    };
    AppComponent.prototype.AppComponent = function () {
        this.liste.push("Inci");
        this.liste.push("Abbas");
        this.liste.push("Murat");
        this.liste.push("Döndu");
        this.liste.push("Mustafa");
        this.liste.push("Nazmiye");
    };
    AppComponent.prototype.onSelect = function () {
        this.showDetail = true;
    };
    AppComponent = __decorate([
        core_1.Component({
            selector: 'my-app',
            template: " \n  Test {{contacts[name]}} mein list: {{liste[1]}} \n  <input \n    type=\"text\"\n    (keyup)=\"onKeyUp()\"\n    (input)=\"color=$event.target.value\"\n    [style.background-color]=\"color\"\n    >\n"
        }), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map