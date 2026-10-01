import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class HoldingService {
  private apiUrl = "http://localhost:8081/holdings";

  constructor(private http: HttpClient) {}

  getHoldings(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}
