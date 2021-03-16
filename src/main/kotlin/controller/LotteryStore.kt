package controller

import domain.LotteryFactory
import domain.WinnerLottery
import view.InputView
import view.InputView.printInputLastWinnerLottery
import view.ResultView
import view.ResultView.printMatchNumbers

fun main() {
    InputView.printInputPrice()

    val inputMoney = Reception.receiveMoney()

    val factory = LotteryFactory(inputMoney)

    println("${factory.calculateLotteryCountByPrice()}개를 구매하였습니다.")

    val createdTicket = factory.buy()

    val lotteries = createdTicket.lotteries

    ResultView.printLotteriesNumbers(lotteries)

    printInputLastWinnerLottery()

    val receiveWinnerLottery = Reception.receiveWinnerLottery()
    val winnerLottery = WinnerLottery(receiveWinnerLottery)

    val match = winnerLottery.match(lotteries)

    printMatchNumbers(3, 6, match)
}
