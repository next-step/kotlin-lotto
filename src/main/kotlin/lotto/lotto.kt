package lotto

import lotto.common.InputValidation
import lotto.domain.Draw
import lotto.view.ResultView
import view.InputView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val draw = Draw()
    val inputValidation = InputValidation()

    // 구입하기
    val amount = inputValidation.amountValidate(inputView.start())
    val num = draw.calculateBuyNum(amount)
    resultView.buyLottery(num)

    // 로또 구입 내역 보여주기
    val lotteries = draw.drawLotteries(num)
    lotteries.forEach { resultView.printLottery(it) }

    // 지난주 당첨번호 입력 받기
    val winLottery = inputValidation.winLotteryValidation(inputView.winLottery())
    val winLotteryResult = draw.calculateWin(winLottery, lotteries)
    resultView.printWinResult(winLotteryResult)
}
