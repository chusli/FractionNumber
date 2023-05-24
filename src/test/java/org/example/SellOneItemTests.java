package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SellOneItemTests {

    Sale sale;
    Display display;

    Map<String, String> prices;

    @BeforeEach
    void setup() {
        prices = new HashMap<>();
    }

    @Test
    void barcodeKnown() {
        prices.put("124981", "CHF 56.55");
        sale = new Sale(new Catalog(prices));
        display = new Display(sale);

        sale.onBarcode("124981");
        String actual = display.getSalePrice();

        assertThat(actual).isEqualTo("CHF 56.55");
    }

    @Test
    void anotherBarcodeKnown() {
        prices.put("324452", "CHF 99.95");
        sale = new Sale(new Catalog(prices));
        display = new Display(sale);

        sale.onBarcode("324452");
        String actual = display.getSalePrice();

        assertThat(actual).isEqualTo("CHF 99.95");
    }

    @Test
    void unknownBarcode() {
        prices.put("324452", "CHF 99.95");
        sale = new Sale(new Catalog(prices));
        display = new Display(sale);

        sale.onBarcode("9999");
        String actual = display.getSalePrice();

        assertThat(actual).isEqualTo("Unknown product: 9999");
    }

    @Test
    void otherUnknownBarcode() {
        prices.put("324452", "CHF 99.95");
        sale = new Sale(new Catalog(prices));
        display = new Display(sale);

        sale.onBarcode("11");
        String actual = display.getSalePrice();

        assertThat(actual).isEqualTo("Unknown product: 11");
    }

    @Test
    void nullBarcode() {
        prices.put("324452", "CHF 99.95");
        sale = new Sale(new Catalog(prices));
        display = new Display(sale);

        sale.onBarcode(null);
        String actual = display.getSalePrice();

        assertThat(actual).isEqualTo("Invalid input :-(");
    }

    @Test
    void emptyBarcode() {
        sale = new Sale(new Catalog(prices));
        display = new Display(sale);

        sale.onBarcode("");
        String actual = display.getSalePrice();

        assertThat(actual).isEqualTo("Invalid input :-(");
    }

    @Test
    void noBarcode() {
        sale = new Sale(new Catalog(prices));
        display = new Display(sale);

        String actual = display.getSalePrice();

        assertThat(actual).isEqualTo("Invalid input :-(");
    }

    private static class Sale {
        private final Catalog catalog;
        private String price = "Invalid input :-(";

        public Sale(Catalog catalog) {

            this.catalog = catalog;
        }

        public void onBarcode(String barcode) {
            if (isValidBarcode(barcode)) {
                return;
            }

            price = catalog.findFormattedPrice(barcode);
        }

        private boolean isValidBarcode(String barcode) {
            return barcode == null || barcode.isBlank();
        }
    }

    private static class Display {

        private final Sale sale;

        public Display(Sale sale) {
            this.sale = sale;
        }

        public String getSalePrice() {
            return sale.price;
        }
    }

    private static class Catalog {

        Map<String, String> catalog;

        public Catalog(Map<String, String> prices) {
            this.catalog = prices;
        }

        public String findFormattedPrice(String barcode) {
            return catalog.getOrDefault(barcode, String.format("Unknown product: %s", barcode));
        }
    }
}
