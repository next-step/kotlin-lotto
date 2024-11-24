package lotto

fun main() {
    val purchasePrice = InputView.getPurchasePrice()
    val price = Price(purchasePrice)

    val lottoNumbers = LottoIssuer.buy(price)

    lottoNumbers.forEach { numbers ->
        println(numbers.numbers.joinToString { it.value.toString() })
    }
}