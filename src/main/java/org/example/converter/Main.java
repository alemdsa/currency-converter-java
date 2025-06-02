package org.example.converter;

public class Main {
    public static void main(String[] args) {
        CurrencyConverterService service = new CurrencyConverterService();
        double result = service.convert("USD", "UAH", 10);
        System.out.println("10 USD -> " + result + " UAH");
    }
}
