package lotto

import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.WinningNumbers
import lotto.domain.WinningStatistics
import lotto.ui.Input
import lotto.ui.Output

fun main() {
    val moneyInput: Long = Input.readMoney()
    val money: Money = Money(moneyInput)

    val lottos = Lottos.from(money)
    Output.printBuyCount(lottos.buyCount)
    Output.printLottos(lottos.lottoList)

    val winningNumbersInput = Input.readWinningNumbers()
    val winningNumbers = WinningNumbers(winningNumbersInput)

    val winningStatistics = WinningStatistics(winningNumbers)
    winningStatistics.rank(lottos)

    Output.printWinningStatistics(winningStatistics)

}
