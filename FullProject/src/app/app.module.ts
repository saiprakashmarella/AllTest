import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { OperationsComponent } from './operations/operations.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DataComponent } from './data/data.component';
import { HttpClientModule } from '@angular/common/http'
import { dataService } from './data/data.service'
import { MatSnackBarModule } from '@angular/material/snack-bar'
@NgModule({
  declarations: [
    AppComponent,
    OperationsComponent,
    routingComponents,
    DataComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, BrowserAnimationsModule, HttpClientModule, FormsModule, MatSnackBarModule],
  providers: [dataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
