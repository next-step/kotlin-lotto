package lottery

import lottery.domain.Money
import lottery.domain.Wallet
import lottery.domain.lottery.Lottery
import lottery.domain.lottery.generator.RandomLotteryGenerator
import lottery.view.inputPurchaseMoney
import lottery.view.inputWinningLottery
import lottery.view.printLottoResult
import lottery.view.printPurchaseLotteries

fun main() {
    val wallet = Wallet(Money(inputPurchaseMoney()))
    val buyLotteries = wallet.buyLotteries(RandomLotteryGenerator)
    printPurchaseLotteries(buyLotteries)
    val winningLottery = Lottery.from(inputWinningLottery())

    val lottoResult = wallet.calculateLotteryResult(winningLottery)
    printLottoResult(lottoResult)
}
