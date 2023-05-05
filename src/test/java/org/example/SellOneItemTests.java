package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SellOneItemTests {

    Sale sale;
    Display display;

    @Test
    void barcodeKnown() {
        sale = new Sale("124981");
        display = new Display(sale);

        sale.onBarcode("124981");
        String actual = display.getText();

        assertThat(actual).isEqualTo("CHF 56.55");
    }

    @Test
    void anotherBarcodeKnown() {
        sale = new Sale("324452");
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

    private static class Sale {
        private String barcode;
        private String price;

        Sale(String barcode){
            this.barcode = barcode;
        }
        Sale(){
        }

        public void onBarcode(String barcode) {
            if ("324452".equals(barcode)) {
                price = "CHF 99.95";
            } else if ("124981".equals(barcode)) {
                price = "CHF 56.55";
            } else {
                price = "Unknown product: 9999";
            }
        }
    }

    private class Display {

        private Sale sale;

        public Display(Sale sale) {
            this.sale = sale;
        }

        public String getText() {
            return sale.price;
        }
    }
}
