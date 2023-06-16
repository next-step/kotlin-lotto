package lottery

import lottery.domain.Money
import lottery.domain.Wallet
import lottery.domain.lottery.Lottery
import lottery.domain.lottery.generator.RandomLotteryGenerator
import lottery.view.inputBonusLotteryNumber
import lottery.view.inputPurchaseMoney
import lottery.view.inputWinningLottery
import lottery.view.printLottoResult
import lottery.view.printPurchaseLotteries

fun main() {
    val wallet = Wallet(Money(inputPurchaseMoney()))
    val purchaseLotteries = wallet.purchaseLotteries(RandomLotteryGenerator)
    printPurchaseLotteries(purchaseLotteries)
    val winningLottery = Lottery.from(inputWinningLottery())
    inputBonusLotteryNumber()

    val lottoResult = wallet.calculateLotteryResult(winningLottery)
    printLottoResult(lottoResult)
}
