import { Component, OnInit } from '@angular/core';
import { getLocaleDateFormat } from '@angular/common';
import { dataService } from './data.service'
import { MatSnackBar } from '@angular/material/snack-bar'

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.css'],
})
export class DataComponent implements OnInit {
  constructor(private ds: dataService, private snackBar: MatSnackBar) { }
  testData: any = [];
  showAdd: boolean = false;

  ngOnInit() {
    this.getdata();
  }
  getdata() {
    this.ds.getData().subscribe(data => {
      this.testData = data;
      console.log(data);
    },
      error => {
        console.log(error)
      }
    )
  }
  showAddData() {
    this.showAdd = true;

  }
  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }
  AddData(data: any) {
    this.ds.AddData(data).subscribe(data => {
      this.openSnackBar("Data Added", "Success");
    },
      error => {
        this.openSnackBar("Data Added", "fail")
      })
  }
}
