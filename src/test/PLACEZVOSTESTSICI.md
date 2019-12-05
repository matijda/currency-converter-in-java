Places vos tests ici. Utilisation de JUnit5 requise.

On test sur les methodes suivantes:
currencyConverter.MainWindow.convert(String, String, ArrayList<Currency>, Double)
currencyConverter.Currency.convert(Double,Double)

Test Boites Noires:
a) Partitionnement du domaine des entrées eb classes d'équivalence

i) currencyConverter.Currency.convert(Double,Double) == convert(Double amount, Double exchangeValue)


