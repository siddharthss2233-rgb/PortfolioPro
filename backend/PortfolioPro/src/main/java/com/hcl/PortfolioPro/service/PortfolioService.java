package com.hcl.PortfolioPro.service;

import com.hcl.PortfolioPro.model.Portfolio;
import com.hcl.PortfolioPro.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    // Create - POST
    public Portfolio save(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    // Read - GET all
    public List<Portfolio> fetchPortfolios() {
        return portfolioRepository.findAll();
    }

    // Read - GET by ID
    public Optional<Portfolio> fetchPortfolioById(Long id) {
        return portfolioRepository.findById(id);
    }

    // Update - PUT
    public Portfolio updatePortfolio(Long id, Portfolio portfolio) {

        Optional<Portfolio> oldPortfolio =
                portfolioRepository.findById(id);

        if (oldPortfolio.isPresent()) {

            Portfolio existingPortfolio = oldPortfolio.get();

            existingPortfolio.setPortfolioName(
                    portfolio.getPortfolioName()
            );

            return portfolioRepository.save(existingPortfolio);
        }

        return null;
    }

    // Delete - DELETE
    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }
}