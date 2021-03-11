package lotto.view

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.Money

class InputReader {
    fun readBudget(): Money {
        var budget = readLine()

        while (budget.isNullOrBlank()) {
            budget = readLine()
        }

        return Money(budget)
    }

    fun readWinningLottoNumbers(): Lotto {
        var winningNumbers = readLine()

        while (winningNumbers.isNullOrBlank()) {
            winningNumbers = readLine()
        }

        return Lotto(winningNumbers)
    }

    fun readBonusNumber(winningLotto: Lotto): LottoNumber {
        var bonusNumber = readLine()

        while (bonusNumber.isNullOrBlank() || winningLotto.hasNumber(LottoNumber(bonusNumber))) {
            bonusNumber = readLine()
        }

        return LottoNumber(bonusNumber)
    }
}
