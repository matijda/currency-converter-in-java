package currencyConverter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    //T1 = { (50.0, USD vers GPB), (-50.0, USD vers GPB), (50.0, CAD vers GPB)}
    @Test
    void test1() {
        Currency USD = new Currency("US Dollar", "USD");
        USD.defaultValues();
        assertTrue(Currency.convert(50.0, USD.getExchangeValues().get("EUR")) > 0);
    }

    @Test
    void test2(){
        Currency USD = new Currency("US Dollar", "USD");
        USD.defaultValues();
        assertTrue(Currency.convert(-50.0, USD.getExchangeValues().get("EUR")) < 0);
    }

    @Test
    void test3(){
        Currency CAD = new Currency("Canadian Dollar", "CAD");
        CAD.defaultValues();
        assertTrue(Currency.convert(50.0, CAD.getExchangeValues().get("EUR")) > 0);
    }

    //T2 = {-1.0, 0.0, Infini}
    @Test
    void test4(){
        Currency USD = new Currency("US Dollar", "USD");
        USD.defaultValues();
        assertTrue(Currency.convert(-1.0, USD.getExchangeValues().get("EUR")) < 0);
    }

    @Test
    void test5(){
        Currency USD = new Currency("US Dollar", "USD");
        USD.defaultValues();
        assertTrue(Currency.convert(0.0, USD.getExchangeValues().get("EUR")) == 0);
    }

    @Test
    void test6(){
        Currency USD = new Currency("US Dollar", "USD");
        USD.defaultValues();
        assertTrue(Currency.convert(Double.POSITIVE_INFINITY, USD.getExchangeValues().get("EUR")) > 0);
    }
}