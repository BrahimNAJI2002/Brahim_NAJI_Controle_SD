import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-keynote',
  templateUrl: './keynote.component.html',
  styleUrl: './keynote.component.css'
})
export class KeynoteComponent {
  public  keynotes : any;
  constructor(private http : HttpClient) {
  }
  ngOnInit() {
    this.http.get("http://localhost:8087/api/keynotes").subscribe({
      next : data => {
        this.keynotes = data;
      },
      error : err => {
        console.log(err);
      }
    })
  }
}
