package lotto

import lotto.model.Lotto
import lotto.model.Lottos
import lotto.model.Money
import lotto.view.InstructionView
import lotto.view.ResultView

fun main() {
    val money = getMoney()

    val lottoCount = money.getAvailableLottoCount()
    ResultView.printLottoCount(lottoCount)

    val myLottos = Lottos(lottoCount)
    ResultView.printMyLottos(myLottos)

    val winningLotto = getWinningNumbers()

    InstructionView.printStatisticsInstruction()
    ResultView.printResultStatistics(myLottos, winningLotto)
    ResultView.printEarningRate(myLottos, winningLotto)
}

fun getMoney(): Money {
    InstructionView.printBudgetQuestion()
    var budget = readLine()

    while (budget.isNullOrBlank()) {
        InstructionView.printBudgetQuestion()
        budget = readLine()
    }

    return Money(budget)
}

fun getWinningNumbers(): Lotto {
    InstructionView.printWinningNumberQuestion()
    var winningNumbers = readLine()

    while (winningNumbers.isNullOrBlank()) {
        InstructionView.printWinningNumberQuestion()
        winningNumbers = readLine()
    }

    return Lotto(winningNumbers)
}
