import { Component, OnInit } from "@angular/core";
import { HoldingService } from "./services/holding.service";
import { TransactionService } from "./services/transaction.service";
import { UserService } from "./services/user.service";
import { PortfolioService } from "./services/portfolio.service";
import { StockService } from "./services/stock.service";

@Component({
  selector: "app-root",
  standalone: true,
  templateUrl: "./app.html",
  styleUrl: "./app.css",
})
export class App implements OnInit {
  users: any[] = [];
  portfolios: any[] = [];
  stocks: any[] = [];
  holdings: any[] = [];
  transactions: any[] = [];

  portfolioName: string = "";

  activeSection: string = "dashboard";

  constructor(
    private userService: UserService,
    private portfolioService: PortfolioService,
    private stockService: StockService,
    private holdingService: HoldingService,
    private transactionService: TransactionService,
  ) {}

  ngOnInit(): void {
    this.loadAllData();
  }

  loadAllData(): void {
    this.userService.getUsers().subscribe({
      next: (data) => {
        this.users = data;
      },
      error: (error) => {
        console.error("User Error:", error);
      },
    });

    this.portfolioService.getPortfolios().subscribe({
      next: (data) => {
        this.portfolios = data;
      },
      error: (error) => {
        console.error("Portfolio Error:", error);
      },
    });

    this.stockService.getStocks().subscribe({
      next: (data) => {
        this.stocks = data;
      },
      error: (error) => {
        console.error("Stock Error:", error);
      },
    });

    this.holdingService.getHoldings().subscribe({
      next: (data) => {
        this.holdings = data;
      },
      error: (error) => {
        console.error("Holding Error:", error);
      },
    });

    this.transactionService.getTransactions().subscribe({
      next: (data) => {
        this.transactions = data;
      },
      error: (error) => {
        console.error("Transaction Error:", error);
      },
    });
  }

  navigateTo(section: string): void {
    this.activeSection = section;
  }

  refreshData(): void {
    this.loadAllData();
  }

  createPortfolio(): void {
    if (!this.portfolioName.trim()) {
      alert("Please enter portfolio name");
      return;
    }

    const portfolio = {
      portfolioName: this.portfolioName,
      user: {
        id: 1,
      },
    };

    this.portfolioService.addPortfolio(portfolio).subscribe({
      next: (data) => {
        console.log("Portfolio created:", data);
        this.portfolioName = "";
        this.loadAllData();
        this.activeSection = "portfolio";
      },
      error: (error) => {
        console.error("Create Portfolio Error:", error);
        alert("Unable to create portfolio");
      },
    });
  }
}
