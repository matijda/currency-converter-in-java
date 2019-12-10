package currencyConverter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainWindowTest {

    //T3={(US Dollar, Euro, currencies, 10.0)
    //    (Canadian Dollar, Euro, currencies, 10.0)
    //    (US Dollar, Euro, devises, 10.0)
    //    (US Dollar, Euro, currencies, -10.0) }

    @Test
    void test7(){
        String currency1 = "US Dollar";
        String currency2 = "Euro";
        ArrayList<Currency> currencies = Currency.init();
        double amount = 10.0;

        assertTrue(MainWindow.convert(currency1,currency2,currencies,amount) >= 0.0);
    }

    @Test
    void test8(){
        String currency1 = "Canadian Dollar";
        String currency2 = "Euro";
        ArrayList<Currency> currencies = Currency.init();
        double amount = 10.0;

        assertTrue(MainWindow.convert(currency1,currency2,currencies,amount) != 0.0);
    }

    @Test
    void test9(){
        String currency1 = "US Dollar";
        String currency2 = "Euro";
        ArrayList<Currency> currencies = Currency.init();
        currencies.add(new Currency("Canadian Dollar", "CAD"));
        double amount = 10.0;

        System.out.println(MainWindow.convert(currency1,currency2,currencies,amount));
    }

    @Test
    void test10(){
        String currency1 = "US Dollar";
        String currency2 = "Euro";
        ArrayList<Currency> currencies = Currency.init();
        double amount = -10.0;

        assertTrue(MainWindow.convert(currency1,currency2,currencies,amount) < 0.0);
    }

    ///T4 = T2 = {-1.0, 0.0, Infini}
    @Test
    void test11(){
        String currency1 = "US Dollar";
        String currency2 = "Euro";
        ArrayList<Currency> currencies = Currency.init();
        double amount = -1;

        assertTrue(MainWindow.convert(currency1,currency2,currencies,amount) < 0.0);
    }
    @Test
    void test12(){
        String currency1 = "US Dollar";
        String currency2 = "Euro";
        ArrayList<Currency> currencies = Currency.init();
        double amount = 0.0;

        assertTrue(MainWindow.convert(currency1,currency2,currencies,amount) == 0.0);
    }
    @Test
    void test13(){
        String currency1 = "US Dollar";
        String currency2 = "Euro";
        ArrayList<Currency> currencies = Currency.init();
        double amount = 10.0;

        assertTrue(MainWindow.convert(currency1,currency2,currencies,amount) >= 0.0);
    }

}