package currencyconverter;

import java.util.HashMap;

public class ExchangeRate {

    private HashMap<String, Double> rates;

    // Constructor
    public ExchangeRate() {

        rates = new HashMap<>();

        // Base Currency = USD
        rates.put("USD", 1.00);
        rates.put("INR", 87.45);
        rates.put("EUR", 0.86);
        rates.put("GBP", 0.75);
        rates.put("JPY", 147.20);
        rates.put("AUD", 1.53);
        rates.put("CAD", 1.37);
        rates.put("AED", 3.67);

    }

    // Get Exchange Rate
    public double getRate(String currency) {

        return rates.get(currency.toUpperCase());

    }

    // Check Currency
    public boolean isValidCurrency(String currency) {

        return rates.containsKey(currency.toUpperCase());

    }

    // Display Supported Currencies
    public void displayCurrencies() {

        System.out.println("\nSupported Currencies");

        for (String currency : rates.keySet()) {

            System.out.println("- " + currency);

        }

    }

}