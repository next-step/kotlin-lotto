package lottery

import lottery.domain.Money
import lottery.domain.RandomLotteryGenerator
import lottery.view.inputPurchaseMoney
import lottery.view.printPurchaseLotteries

fun main() {
    val money = Money(inputPurchaseMoney())
    val wallet = money.purchaseLotteries(RandomLotteryGenerator)
    printPurchaseLotteries(wallet.toPurchasedLotteries())
}
