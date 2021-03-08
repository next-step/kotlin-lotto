package lotto.view

import lotto.model.Lotto
import lotto.model.Money

object InputView {
    fun askBudgetQuestion(): Money {
        printBudgetQuestion()
        var budget = readLine()

        while (budget.isNullOrBlank()) {
            printBudgetQuestion()
            budget = readLine()
        }

        return Money(budget)
    }

    fun askWinningLotto(): Lotto {
        printWinningNumberQuestion()
        var winningNumbers = readLine()

        while (winningNumbers.isNullOrBlank()) {
            printWinningNumberQuestion()
            winningNumbers = readLine()
        }

        return Lotto(winningNumbers)
    }

    fun printBudgetQuestion() {
        println("구입금액을 입력해 주세요.")
    }

    fun printWinningNumberQuestion() {
        println("지난 주 당첨 번호를 입력해 주세요.")
    }
}
