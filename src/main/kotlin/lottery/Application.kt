package lottery

import lottery.domain.Money
import lottery.view.inputPurchaseMoney

fun main() {
    val money = Money(inputPurchaseMoney())
}
