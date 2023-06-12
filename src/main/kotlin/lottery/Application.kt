package lottery

import lottery.domain.Lottery
import lottery.domain.Money
import lottery.domain.RandomLotteryGenerator
import lottery.view.inputPurchaseMoney
import lottery.view.inputWinningLottery
import lottery.view.printLottoResult
import lottery.view.printPurchaseLotteries

fun main() {
    val money = Money(inputPurchaseMoney())
    val wallet = money.purchaseLotteries(RandomLotteryGenerator)
    printPurchaseLotteries(wallet.toPurchasedLotteries())
    val winningLottery = Lottery.from(inputWinningLottery())

    val lottoResult = wallet.calculateLotteryResult(winningLottery)
    printLottoResult(lottoResult)
}
