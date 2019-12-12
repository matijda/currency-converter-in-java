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

        assertEquals(0.0,MainWindow.convert(currency1,currency2,currencies,amount));
    }
    @Test
    void test13(){
        String currency1 = "US Dollar";
        String currency2 = "Euro";
        ArrayList<Currency> currencies = Currency.init();
        double amount = 10.0;

        assertTrue(MainWindow.convert(currency1,currency2,currencies,amount) >= 0.0);
    }

    /* Tests boîtes blanches */

    @Test
    void whiteBoxMainWindow() {
        // Critère de couverture des conditions et des arcs

        // Chemin 1-2-3-4-5-6-7-8-9-10-11-12-13-14-15 (Critère de couverture des instructions)
        assertTrue(MainWindow.convert("US Dollar", "Euro", Currency.init(), 10.0) > 0);
        // Chemin 1-2-3-4-5-8-9-15
        assertEquals(0.0, MainWindow.convert("US Dollar", "Euro", new ArrayList<>(), 10.0));
        // Chemin 1-2-3-4-5-6-7-8-9-10-11-15
        assertEquals(0.0, MainWindow.convert("", "Euro", Currency.init(), 10.0));
        // Chemin 1-2-3-4-5-6-8-9-15
        assertEquals(0.0, MainWindow.convert("", "", Currency.init(), 10.0));
        // Chemin 1-2-3-4-5-6-7-8-9-10-15 Non atteignable
        // Chemin 1-2-3-4-5-8-9-(autres chemins que 15) non atteignable

        // Critère de couverture des i-chemins

        // Saut des deux boucle for
        assertTrue(MainWindow.convert("", "", Currency.init(), 10.0) > 0);

        // 1 passage de la 1re boucle for
        assertTrue(MainWindow.convert("Euro", "US Dollar", Currency.init(), 10.0) > 0);
        // 2 passages de la 1re boucle for
        assertTrue(MainWindow.convert("Euro", "Euro", Currency.init(), 10.0) > 0);
        // 3 passages de la 1re boucle for
        assertTrue(MainWindow.convert("Euro", "British Pound", Currency.init(), 10.0) > 0);
        // 4 passages de la 1re boucle for
        assertTrue(MainWindow.convert("Euro", "Swiss Franc", Currency.init(), 10.0) > 0);
        // 5 passages de la 1re boucle for
        assertTrue(MainWindow.convert("Euro", "Chinese Yuan Renminbi", Currency.init(), 10.0) > 0);
        // 6 passages de la 1re boucle for
        assertTrue(MainWindow.convert("Euro", "Japanese Yen", Currency.init(), 10.0) > 0);

        // 1 passage de la 2e boucle for
        assertTrue(MainWindow.convert("US Dollar", "Euro", Currency.init(), 10.0) > 0);
        // 2 passages de la 2re boucle for
        assertTrue(MainWindow.convert("Euro", "Euro", Currency.init(), 10.0) > 0);
        // 3 passages de la 2re boucle for
        assertTrue(MainWindow.convert("British Pound", "Euro", Currency.init(), 10.0) > 0);
        // 4 passages de la 2re boucle for
        assertTrue(MainWindow.convert("Swiss Franc", "Euro", Currency.init(), 10.0) > 0);
        // 5 passages de la 2re boucle for
        assertTrue(MainWindow.convert("Chinese Yuan Renminbi", "Chinese Yuan Renminbi", Currency.init(), 10.0) > 0);
        // 6 passages de la 2re boucle for
        assertTrue(MainWindow.convert("Japanese Yen", "Euro", Currency.init(), 10.0) > 0);
    }
}