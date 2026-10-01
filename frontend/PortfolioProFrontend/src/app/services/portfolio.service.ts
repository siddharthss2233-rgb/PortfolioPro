import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class PortfolioService {
  private apiUrl = "http://localhost:8081/portfolio";

  constructor(private http: HttpClient) {}

  getPortfolios(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  getPortfolio(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  addPortfolio(portfolio: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, portfolio);
  }

  updatePortfolio(id: number, portfolio: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, portfolio);
  }

  deletePortfolio(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}
