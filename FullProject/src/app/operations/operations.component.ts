import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.css'],
})
export class OperationsComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}
  showData() {
    alert('hi');
    this.router.navigate(['/showdata']);
  }
}
