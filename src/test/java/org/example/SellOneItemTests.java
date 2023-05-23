package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SellOneItemTests {

    Sale sale;
    Display display;

    @Test
    void barcodeKnown() {
        sale = new Sale();
        display = new Display(sale);

        sale.onBarcode("124981");
        String actual = display.getText();

        assertThat(actual).isEqualTo("CHF 56.55");
    }

    @Test
    void anotherBarcodeKnown() {
        sale = new Sale();
        display = new Display(sale);

        sale.onBarcode("324452");
        String actual = display.getText();

        assertThat(actual).isEqualTo("CHF 99.95");
    }

    @Test
    void unknownBarcode() {
        sale = new Sale();
        display = new Display(sale);

        sale.onBarcode("9999");
        String actual = display.getText();

        assertThat(actual).isEqualTo("Unknown product: 9999");
    }

    @Test
    void nullBarcode() {
        sale = new Sale();
        display = new Display(sale);

        sale.onBarcode(null);
        String actual = display.getText();

        assertThat(actual).isEqualTo("Invalid input :-(");
    }

    @Test
    void emptyBarcode() {
        sale = new Sale();
        display = new Display(sale);

        sale.onBarcode("");
        String actual = display.getText();

        assertThat(actual).isEqualTo("Invalid input :-(");
    }

    private static class Sale {
        private String price;

        public void onBarcode(String barcode) {
            if (isValidBarcode(barcode)) {
                price = "Invalid input :-(";
                return;
            }
            Map<String, String> productRegister = new HashMap<>();
            productRegister.put("324452", "CHF 99.95");
            productRegister.put("124981", "CHF 56.55");

            price = productRegister.getOrDefault(barcode, "Unknown product: 9999");
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

        public String getText() {
            return sale.price;
        }
    }
}
