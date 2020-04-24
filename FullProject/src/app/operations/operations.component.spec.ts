import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperationsComponent } from './operations.component';
import { Router } from '@angular/router';
import { BrowserDynamicTestingModule } from '@angular/platform-browser-dynamic/testing';

describe('OperationsComponent', () => {
  let component: OperationsComponent;
  let fixture: ComponentFixture<OperationsComponent>;


  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [OperationsComponent],
      providers: [Router]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
