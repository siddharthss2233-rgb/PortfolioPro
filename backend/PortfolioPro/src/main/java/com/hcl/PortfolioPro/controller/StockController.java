package com.hcl.PortfolioPro.controller;

import com.hcl.PortfolioPro.model.Stock;
import com.hcl.PortfolioPro.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    // POST - Create stock
    @PostMapping
    public Stock saveStock(@RequestBody Stock stock) {
        return stockService.save(stock);
    }

    // GET - Get all stocks
    @GetMapping
    public List<Stock> getStocks() {
        return stockService.fetchStocks();
    }

    // GET - Get stock by ID
    @GetMapping("/{id}")
    public Optional<Stock> getStock(@PathVariable Long id) {
        return stockService.fetchStockById(id);
    }

    // PUT - Update stock
    @PutMapping("/{id}")
    public Stock updateStock(
            @PathVariable Long id,
            @RequestBody Stock stock) {

        return stockService.updateStock(id, stock);
    }

    // DELETE - Delete stock
    @DeleteMapping("/{id}")
    public String deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return "Stock deleted successfully";
    }
}