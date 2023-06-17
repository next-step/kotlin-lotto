package lottery

import lottery.domain.Money
import lottery.domain.Wallet
import lottery.domain.lottery.Lottery
import lottery.domain.lottery.LotteryNumber
import lottery.domain.lottery.WinningLottery
import lottery.domain.lottery.generator.RandomLotteryGenerator
import lottery.view.inputBonusLotteryNumber
import lottery.view.inputPurchaseManualLottery
import lottery.view.inputPurchaseMoney
import lottery.view.inputWinningLottery
import lottery.view.printLottoResult
import lottery.view.printPurchaseLotteries

fun main() {
    val wallet = Wallet(Money(inputPurchaseMoney()))
    purchaseLottery(wallet)

    val winningLottery = WinningLottery(Lottery.from(inputWinningLottery()), LotteryNumber(inputBonusLotteryNumber()))
    val lottoResult = wallet.calculateLotteryResult(winningLottery)
    printLottoResult(lottoResult)
}

private fun purchaseLottery(wallet: Wallet) {
    val manualLottery = inputPurchaseManualLottery()
    wallet.purchaseManualLotteries(manualLottery)
    wallet.purchaseLotteries(RandomLotteryGenerator)
    printPurchaseLotteries(wallet.purchasedLotteries())
}
