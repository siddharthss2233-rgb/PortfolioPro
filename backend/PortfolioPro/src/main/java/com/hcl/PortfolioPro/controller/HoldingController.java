package com.hcl.PortfolioPro.controller;

import com.hcl.PortfolioPro.model.Holding;
import com.hcl.PortfolioPro.service.HoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/holdings")
public class HoldingController {

    @Autowired
    private HoldingService holdingService;

    @PostMapping
    public Holding saveHolding(@RequestBody Holding holding) {
        return holdingService.save(holding);
    }

    @GetMapping
    public List<Holding> getHoldings() {
        return holdingService.fetchHoldings();
    }

    @GetMapping("/{id}")
    public Optional<Holding> getHolding(@PathVariable Long id) {
        return holdingService.fetchHoldingById(id);
    }

    @PutMapping("/{id}")
    public Holding updateHolding(
            @PathVariable Long id,
            @RequestBody Holding holding) {
        return holdingService.updateHolding(id, holding);
    }

    @DeleteMapping("/{id}")
    public String deleteHolding(@PathVariable Long id) {
        holdingService.deleteHolding(id);
        return "Holding deleted successfully";
    }
}