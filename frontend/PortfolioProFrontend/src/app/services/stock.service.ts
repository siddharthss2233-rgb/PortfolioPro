import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class StockService {
  private apiUrl = "http://localhost:8081/stocks";

  constructor(private http: HttpClient) {}

  getStocks(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  getStock(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  addStock(stock: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, stock);
  }

  updateStock(id: number, stock: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, stock);
  }

  deleteStock(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}
