package controller

import domain.Lotteries
import view.InputView

class LotteryStore {
    fun main() {
        InputView.printInputPrice()
        val numberOfLottery = Reception.receiveNumberOfLottery()

        val lotteries = Lotteries.of(numberOfLottery)
    }
}
