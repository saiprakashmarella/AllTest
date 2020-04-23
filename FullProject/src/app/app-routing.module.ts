import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OperationsComponent } from './operations/operations.component';
import { DataComponent } from './data/data.component';

const routes: Routes = [
  { path: '', component: OperationsComponent },
  { path: 'showdata', component: DataComponent },

  { path: '**', component: OperationsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
export const routingComponents = [OperationsComponent, DataComponent];
