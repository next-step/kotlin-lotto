package lotto.view

import lotto.model.Lotto
import lotto.model.LottoNumber
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

    fun askBonusNumber(winningLotto: Lotto): LottoNumber {
        printBonusBallQuestion()
        var bonusNumber = readLine()

        while (bonusNumber.isNullOrBlank() || winningLotto.hasNumber(LottoNumber(bonusNumber))) {
            printBonusBallQuestion()
            bonusNumber = readLine()
        }

        return LottoNumber(bonusNumber)
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

    fun printBonusBallQuestion() {
        println("보너스 볼을 입력해 주세요.")
    }

    fun printBudgetQuestion() {
        println("구입금액을 입력해 주세요.")
    }

    fun printWinningNumberQuestion() {
        println("지난 주 당첨 번호를 입력해 주세요.")
    }
}
