package com.hcl.PortfolioPro.service;

import com.hcl.PortfolioPro.model.Stock;
import com.hcl.PortfolioPro.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    // Create - POST
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    // Read - GET all
    public List<Stock> fetchStocks() {
        return stockRepository.findAll();
    }

    // Read - GET by ID
    public Optional<Stock> fetchStockById(Long id) {
        return stockRepository.findById(id);
    }

    // Update - PUT
    public Stock updateStock(Long id, Stock stock) {

        Optional<Stock> oldStock = stockRepository.findById(id);

        if (oldStock.isPresent()) {
            Stock existingStock = oldStock.get();

            existingStock.setSymbol(stock.getSymbol());
            existingStock.setCompanyName(stock.getCompanyName());
            existingStock.setPrice(stock.getPrice());

            return stockRepository.save(existingStock);
        }

        return null;
    }

    // Delete - DELETE
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}