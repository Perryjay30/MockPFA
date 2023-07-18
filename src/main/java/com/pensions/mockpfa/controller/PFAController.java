package com.pensions.mockpfa.controller;

import com.pensions.mockpfa.services.PFAService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mockPFA")
@RequiredArgsConstructor
public class PFAController {

    private final PFAService pfaService;

    List<String> randomPFA = List.of("PAL Pension", "Stanbic Pension", "Leadway Pension", "Access Pension");
    List<String> randomName = List.of("Perry", "Peter", "Samuel", "James");
    Map<String, String> mapper = new HashMap<>();

    @GetMapping
    public ResponseEntity<?> createAccount() {
        String rsaPin = pfaService.generateRSAPin(10);
        mapper.put("RSA pin", rsaPin);
        mapper.put("name", pfaService.generatePFA(randomName));
        mapper.put("PFA", pfaService.generatePFA(randomPFA));
        return new ResponseEntity<>(mapper, HttpStatus.OK);
    }
}
