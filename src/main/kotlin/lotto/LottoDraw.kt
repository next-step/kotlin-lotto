package lotto

fun main() {
    val purchasePrice = InputView.getPurchasePrice()
    val price = Price(purchasePrice)

    val issue = LottoIssuer.issue(price)
}