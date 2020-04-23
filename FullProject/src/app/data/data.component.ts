import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.css'],
})
export class DataComponent implements OnInit {
  constructor() {}
  data: any = [];

  ngOnInit() {
    this.data.push({ name: 'sai', age: '23', country: 'India' });
    this.data.push({ name: 'prakash', age: '23', country: 'India' });
    this.data.push({ name: 'marella', age: '23', country: 'India' });
    console.log(this.data);
  }
}
