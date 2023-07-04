package lottery.controller

import lottery.domain.Lotteries
import lottery.domain.Lottery
import lottery.domain.LotteryNumber
import lottery.domain.LotteryPrize
import lottery.domain.LotteryRank
import lottery.domain.WinningLottery
import lottery.view.LotteryGameView

class LotteryGame {
    private lateinit var winningLottery: WinningLottery
    private val lotteryRank = LotteryRank()
    fun purchaseAutoLotteries(purchasePrice: Int): Lotteries {
        return Lotteries.makeAutoLotteries(purchasePrice / Lottery.LOTTERY_PRICE)
    }

    fun start() {
        LotteryGameView.printPurchaseMoneyView()
        val money = readln().toInt()
        val purchaseAutoLotteries = purchaseAutoLotteries(money)
        LotteryGameView.printPurchaseLotteryView(purchaseAutoLotteries.lotteries.size)
        LotteryGameView.printLotteriesNumber(purchaseAutoLotteries)
        LotteryGameView.printWinnerLotteryNumber()
        val numbers = readln().replace("\\s".toRegex(), "").split(",")
        winningLottery = WinningLottery(numbers.map { LotteryNumber.get(it.toInt()) }.toSet())

        purchaseAutoLotteries.lotteries.forEach {
            val checkRank = it.checkRank(winningLottery.winningNumbers)
            lotteryRank.plusRank(LotteryPrize.get(checkRank) ?: LotteryPrize.NONE)
        }
        LotteryGameView.printLotteryRankView(lotteryRank)
        LotteryGameView.printProfitView(lotteryRank.calculateProfit(money))
    }
}

fun main() {
    val game = LotteryGame()
    game.start()
}
