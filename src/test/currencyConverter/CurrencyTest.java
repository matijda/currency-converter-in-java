package currencyConverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    /* Tests boîte noire (tests boîte blanche inclue puisque la méthode est dépourvue de structure de contrôle)*/

    //T1 = { (-50.0, USD vers GPB), (0, USD vers GPB), (50.0, USD vers GPB)}
    @Test
    void test1() {
        Currency USD = new Currency("US Dollar", "USD");
        USD.defaultValues();
        assertTrue(Currency.convert(-50.0, USD.getExchangeValues().get("EUR")) < 0);
    }

    @Test
    void test2(){
        Currency USD = new Currency("US Dollar", "USD");
        USD.defaultValues();
        assertEquals(0.0, Currency.convert(0.0, USD.getExchangeValues().get("EUR")));
    }

    @Test
    void test3(){
        Currency CAD = new Currency("US Dollar", "USD");
        CAD.defaultValues();
        assertTrue(Currency.convert(50.0, CAD.getExchangeValues().get("EUR")) > 0);
    }

    // T2 = {-Infini, 0.0, Infini}

    @Test
    void test4(){
        Currency USD = new Currency("US Dollar", "USD");
        USD.defaultValues();
        assertTrue(Currency.convert(Double.NEGATIVE_INFINITY, USD.getExchangeValues().get("EUR")) < 0);
    }

    @Test
    void test5(){
        Currency USD = new Currency("US Dollar", "USD");
        USD.defaultValues();
        assertEquals(0, (double) Currency.convert(0.0, USD.getExchangeValues().get("EUR")));
    }

    @Test
    void test6(){
        Currency USD = new Currency("US Dollar", "USD");
        USD.defaultValues();
        assertTrue(Currency.convert(Double.POSITIVE_INFINITY, USD.getExchangeValues().get("EUR")) > 0);
    }
}