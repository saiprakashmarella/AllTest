import { Injectable } from '@angular/core'
import { HttpClient, HttpErrorResponse } from '@angular/common/http'
import { Observable, throwError } from 'rxjs'
import { data } from './data'
import { catchError, retry } from 'rxjs/operators'
@Injectable()
export class dataService {
    constructor(private http: HttpClient) { }
    getData(): Observable<data[]> {
        return this.http.get<data[]>("http://localhost:8080/test/showData")
            .pipe(catchError(this.handleError),
                retry(3));
    }
    AddData(data: data): Observable<data> {
        return this.http.post<data>("http://localhost:8080/test/addData", data)
            .pipe(catchError(this.handleError), retry(3));
    }
    handleError(error: HttpErrorResponse) {
        console.log("error occured" + error);
        return throwError(error);
    }
}