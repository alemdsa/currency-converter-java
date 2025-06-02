package org.example.converter;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterService {

    private final Map<String, Double> exchangeRates = new HashMap<>();

    public CurrencyConverterService() {
        // Базові курси по відношенню до USD
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.9);
        exchangeRates.put("UAH", 38.0);
    }

    public double convert(String from, String to, double amount) {
        if (!exchangeRates.containsKey(from) || !exchangeRates.containsKey(to)) {
            throw new IllegalArgumentException("Unsupported currency");
        }

        double usdAmount = amount / exchangeRates.get(from);
        return usdAmount * exchangeRates.get(to);
    }
}

