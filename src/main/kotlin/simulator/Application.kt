package simulator

import simulator.io.Input
import simulator.io.Output
import simulator.lotto.LottoMachine
import simulator.lotto.NumberGenerator
import simulator.lotto.Ranks
import simulator.lotto.WinningNumber

fun main() {
    val input = Input()
    val output = Output()
    val generator = NumberGenerator()
    val money = input.getMoney()
    val count = money / 1000

    val manualCount = input.getManualCount()

    var lottoList = input.getManualNumbers(manualCount)
    lottoList = lottoList.plus(LottoMachine(generator).create(count))

    output.printTimes(manualCount, count - manualCount)
    output.printLottoList(lottoList)

    val winningNumbers = input.getWinningNumbers()
    val bonusNumber = input.getBonusNumber()

    val ranks = Ranks.match(lottoList, WinningNumber(winningNumbers, bonusNumber))

    output.printResult(ranks)
    output.printYield(ranks.yield(money))
}