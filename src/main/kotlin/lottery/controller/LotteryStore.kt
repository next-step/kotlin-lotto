package lottery.controller

import lottery.domain.LotteryFactory
import lottery.domain.WinnerLottery
import lottery.view.InputView
import lottery.view.InputView.printInputLastWinnerLottery
import lottery.view.ResultView
import lottery.view.ResultView.printMatchNumbers

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
