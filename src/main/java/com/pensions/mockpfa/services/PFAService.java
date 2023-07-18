package com.pensions.mockpfa.services;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class PFAService {
    private SecureRandom randomPin = new SecureRandom();

    public String generateRSAPin(int len) {
        StringBuilder randomNumber = new StringBuilder(len);
        for(int i = 0; i < len; i++){
            String combineWord = "0123456789";
            randomNumber.append(combineWord.charAt(randomPin.nextInt(combineWord.length())));
        }
        return new String(randomNumber);
    }

    public String generatePFA(List<String> stringList) {
        int listSize = stringList.size();
        int randomIndex = randomPin.nextInt(listSize);
        return stringList.get(randomIndex);
    }
}
