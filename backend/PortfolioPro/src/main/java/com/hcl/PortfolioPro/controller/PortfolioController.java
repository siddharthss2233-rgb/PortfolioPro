package com.hcl.PortfolioPro.controller;

import com.hcl.PortfolioPro.model.Portfolio;
import com.hcl.PortfolioPro.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @PostMapping
    public Portfolio savePortfolio(@RequestBody Portfolio portfolio) {
        return portfolioService.save(portfolio);
    }

    @GetMapping
    public List<Portfolio> getPortfolios() {
        return portfolioService.fetchPortfolios();
    }

    @GetMapping("/{id}")
    public Optional<Portfolio> getPortfolio(@PathVariable Long id) {
        return portfolioService.fetchPortfolioById(id);
    }

    @PutMapping("/{id}")
    public Portfolio updatePortfolio(
            @PathVariable Long id,
            @RequestBody Portfolio portfolio) {
        return portfolioService.updatePortfolio(id, portfolio);
    }

    @DeleteMapping("/{id}")
    public String deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);
        return "Portfolio deleted successfully";
    }
}