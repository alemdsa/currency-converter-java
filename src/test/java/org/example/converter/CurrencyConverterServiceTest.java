package org.example.converter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CurrencyConverterServiceTest {

    @Test
    public void testConversionUsdToEur() {
        CurrencyConverterService service = new CurrencyConverterService();
        double result = service.convert("USD", "EUR", 100);
        assertEquals(90, result, 0.01);
    }

    @Test
    public void testConversionUahToUsd() {
        CurrencyConverterService service = new CurrencyConverterService();
        double result = service.convert("UAH", "USD", 38);
        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testInvalidCurrency() {
        CurrencyConverterService service = new CurrencyConverterService();
        assertThrows(IllegalArgumentException.class, () -> service.convert("USD", "BTC", 100));
    }
}

