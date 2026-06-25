/**
 * CurrencyConverter.java
 *
 * A beginner-friendly Java Currency Converter.
 * Uses the FREE ExchangeRate-API (no API key needed!):
 *   https://open.er-api.com/v6/latest/{BASE_CURRENCY}
 *
 * HOW TO COMPILE & RUN:
 *   javac CurrencyConverter.java
 *   java CurrencyConverter
 *
 * REQUIRES: Java 11 or above (uses java.net.http.HttpClient)
 */

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    // -----------------------------------------------------------
    // The FREE API endpoint (no key required)
    // Replace {BASE} with any currency code like USD, INR, EUR
    // -----------------------------------------------------------
    private static final String API_URL = "https://open.er-api.com/v6/latest/";

    // -----------------------------------------------------------
    // Popular currencies the user can choose from
    // LinkedHashMap keeps insertion order for display
    // -----------------------------------------------------------
    private static final Map<Integer, String[]> CURRENCIES = new LinkedHashMap<>();

    static {
        // Format: number -> { "CODE", "Currency Name", "Symbol" }
        CURRENCIES.put(1,  new String[]{"USD", "US Dollar",           "$"    });
        CURRENCIES.put(2,  new String[]{"INR", "Indian Rupee",        "Rs."  });
        CURRENCIES.put(3,  new String[]{"EUR", "Euro",                "EUR"  });
        CURRENCIES.put(4,  new String[]{"GBP", "British Pound",       "GBP"  });
        CURRENCIES.put(5,  new String[]{"JPY", "Japanese Yen",        "JPY"  });
        CURRENCIES.put(6,  new String[]{"AUD", "Australian Dollar",   "AUD"  });
        CURRENCIES.put(7,  new String[]{"CAD", "Canadian Dollar",     "CAD"  });
        CURRENCIES.put(8,  new String[]{"AED", "UAE Dirham",          "AED"  });
        CURRENCIES.put(9,  new String[]{"SGD", "Singapore Dollar",    "SGD"  });
        CURRENCIES.put(10, new String[]{"CHF", "Swiss Franc",         "CHF"  });
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("      JAVA CURRENCY CONVERTER            ");
        System.out.println("     (Live Rates via ExchangeRate-API)   ");
        System.out.println("==========================================");

        boolean running = true;

        while (running) {

            // --- STEP 1: Show currency menu and pick BASE currency ---
            System.out.println("\nAvailable Currencies:");
            System.out.println("------------------------------------------");
            System.out.printf("  %-4s %-6s %-25s %s%n", "No.", "Code", "Name", "Symbol");
            System.out.println("------------------------------------------");
            for (Map.Entry<Integer, String[]> entry : CURRENCIES.entrySet()) {
                String[] c = entry.getValue();
                System.out.printf("  %-4d %-6s %-25s %s%n",
                        entry.getKey(), c[0], c[1], c[2]);
            }
            System.out.println("------------------------------------------");

            System.out.print("\nEnter number for BASE currency which will be converted (e.g., 1 for USD): ");
            int baseChoice = getValidMenuChoice(scanner, 1, 10);
            String[] baseCurrency = CURRENCIES.get(baseChoice);

            // --- STEP 2: Pick TARGET currency ---
            System.out.print("Enter number for TARGET currency which is required (e.g., 2 for INR): ");
            int targetChoice = getValidMenuChoice(scanner, 1, 10);
            String[] targetCurrency = CURRENCIES.get(targetChoice);

            // Warn if same currency selected
            if (baseChoice == targetChoice) {
                System.out.println("\n  NOTE: Base and target currencies are the same.");
                System.out.println("  The result will always equal your input amount.");
            }

            // --- STEP 3: Enter amount ---
            System.out.printf("%nEnter amount in %s (%s): ", baseCurrency[1], baseCurrency[2]);
            double amount = getValidAmount(scanner);

            // --- STEP 4: Fetch live exchange rate from API ---
            System.out.println("\n  Fetching live exchange rate.... please wait.");
            double rate = fetchExchangeRate(baseCurrency[0], targetCurrency[0]);

            if (rate == -1) {
                System.out.println("\n  ERROR: Could not fetch exchange rate.");
                System.out.println("  Please check your internet connection and try again.");
            } else {
                // --- STEP 5: Calculate and display result ---
                double convertedAmount = amount * rate;

                System.out.println("\n==========================================");
                System.out.println("           CONVERSION RESULT              ");
                System.out.println("==========================================");
                System.out.printf("  %s %.2f  (%s)%n",
                        baseCurrency[2], amount, baseCurrency[0]);
                System.out.println("            converts to");
                System.out.printf("  %s %.2f  (%s)%n",
                        targetCurrency[2], convertedAmount, targetCurrency[0]);
                System.out.println("------------------------------------------");
                System.out.printf("  Exchange Rate: 1 %s = %.4f %s%n",
                        baseCurrency[0], rate, targetCurrency[0]);
                System.out.println("  (Rates provided by open.er-api.com)");
                System.out.println("==========================================");
            }

            // --- Ask if user wants to convert again ---
            System.out.print("\nDo you want to convert again? (yes/no): ");
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("yes") && !again.equals("y")) {
                running = false;
                System.out.println("\n  Thank you for using Java Currency Converter! Have a good day!");
                System.out.println("=================================================================");
            }
        }

        scanner.close();
    }

    // -------------------------------------------------------
    // Fetches the exchange rate from the free API
    // Returns the rate as a double, or -1 if it fails
    // -------------------------------------------------------
    private static double fetchExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            // Build the URL: e.g., https://open.er-api.com/v6/latest/USD
            String url = API_URL + baseCurrency;

            // Create an HTTP client (available in Java 11+)
            HttpClient client = HttpClient.newHttpClient();

            // Build the GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Send request and get the response body as a String
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            // -------------------------------------------------------
            // Parse the JSON manually (no external library needed!)
            // The API response looks like:
            // { "result": "success", "rates": { "INR": 83.5, "EUR": 0.92, ... } }
            // We search for the target currency code in the JSON string.
            // -------------------------------------------------------
            if (!responseBody.contains("\"result\":\"success\"")) {
                return -1; // API returned an error
            }

            // Find the target currency in the JSON string
            String searchKey = "\"" + targetCurrency + "\":";
            int keyIndex = responseBody.indexOf(searchKey);

            if (keyIndex == -1) {
                return -1; // Currency not found in response
            }

            // Extract the number right after the colon
            int start = keyIndex + searchKey.length();
            int end = responseBody.indexOf(",", start);

            // Handle case where it's the last item before closing "}"
            if (end == -1) {
                end = responseBody.indexOf("}", start);
            }

            String rateString = responseBody.substring(start, end).trim();
            return Double.parseDouble(rateString);

        } catch (Exception e) {
            // Network error, timeout, bad response, etc.
            System.out.println("  [Error]: " + e.getMessage());
            return -1;
        }
    }

    // -------------------------------------------------------
    // Reads a valid menu choice (between min and max)
    // Keeps asking until user enters a valid number
    // -------------------------------------------------------
    private static int getValidMenuChoice(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.printf("  Please enter a number between %d and %d: ", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.print("  Invalid input. Please enter a number: ");
            }
        }
    }

    // -------------------------------------------------------
    // Reads a valid positive amount from the user
    // Keeps asking until user enters a number > 0
    // -------------------------------------------------------
    private static double getValidAmount(Scanner scanner) {
        while (true) {
            try {
                double amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount > 0) {
                    return amount;
                } else {
                    System.out.print("  Amount must be greater than zero. Try again: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("  Invalid amount. Please enter a number (e.g., 100.50): ");
            }
        }
    }
}
