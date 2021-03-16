package lottery.controller

import lottery.domain.LotteryFactory
import lottery.domain.LotteryMatcher
import lottery.domain.Rank
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

    LotteryMatcher(winnerLottery, lotteries)

    val match = winnerLottery.match(lotteries)

    printMatchNumbers(Rank.FOURTH.matchCount, Rank.FIRST.matchCount, match)
}
