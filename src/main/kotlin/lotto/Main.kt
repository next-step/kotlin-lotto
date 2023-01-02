package lotto

import lotto.domain.Lottery
import lotto.domain.LotteryMachine
import lotto.view.LotteryMachineInputView
import lotto.view.LotteryMachineOutputView

fun main() {

    val payAmount = LotteryMachineInputView.inputPayAmount()
    val lotteries = LotteryMachine.buyLotteries(payAmount)
    LotteryMachineOutputView.printLotteries(lotteries)

    val lastWinningLottery = Lottery(LotteryMachineInputView.inputLastWinningNumbers())

    val result = LotteryMachine.getMatchCount(lotteries, lastWinningLottery)
    LotteryMachineOutputView.printResult(result, LotteryMachine.calculateReturnRate(payAmount, result))
}
