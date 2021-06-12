package com.tourism.tourism.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/seed")
public class SeedController {
    @Autowired
    private SeedService seedService;

    @PutMapping(path = "all")
    public void runAll() {
        seedService.runAll();
    }

    @GetMapping(path = "health")
    public Boolean health() {
        return true;
    }

    @PutMapping(path = "tourist-anonymous")
    public void runTouristAnonymous() {
        seedService.runTouristAnonymous();
    }

    @PutMapping(path = "employee-admin")
    public void runEmployeeAdmin() {
    seedService.runEmployeeAdmin();
    }
}
