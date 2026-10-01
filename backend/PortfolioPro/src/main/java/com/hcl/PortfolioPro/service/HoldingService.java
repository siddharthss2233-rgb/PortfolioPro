package com.hcl.PortfolioPro.service;

import com.hcl.PortfolioPro.model.Holding;
import com.hcl.PortfolioPro.repository.HoldingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoldingService {

    @Autowired
    private HoldingRepository holdingRepository;

    public Holding save(Holding holding) {
        return holdingRepository.save(holding);
    }

    public List<Holding> fetchHoldings() {
        return holdingRepository.findAll();
    }

    public Optional<Holding> fetchHoldingById(Long id) {
        return holdingRepository.findById(id);
    }

    public Holding updateHolding(Long id, Holding holding) {
        Optional<Holding> oldHolding = holdingRepository.findById(id);

        if (oldHolding.isPresent()) {
            Holding existingHolding = oldHolding.get();

            existingHolding.setQuantity(holding.getQuantity());

            return holdingRepository.save(existingHolding);
        }

        return null;
    }

    public void deleteHolding(Long id) {
        holdingRepository.deleteById(id);
    }
}