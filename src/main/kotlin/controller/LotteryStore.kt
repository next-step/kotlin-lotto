package controller

import domain.Lotteries
import view.InputView
import view.ResultView

class LotteryStore {
    fun main() {
        InputView.printInputPrice()
        val numberOfLottery = Reception.receiveNumberOfLottery()

        val lotteries = Lotteries.of(numberOfLottery)
    }
}
