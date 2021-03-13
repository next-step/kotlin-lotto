package lotto.view

import lotto.model.game.Lotto
import lotto.model.game.LottoNumber
import lotto.model.input.Money

class InputReader {
    fun readBudget(): Money {
        var budget = readLine()

        while (budget.isNullOrBlank()) {
            budget = readLine()
        }

        return Money(budget)
    }

    fun readManualCount(): Int {
        var count = readLine()

        while (count.isNullOrBlank()) {
            count = readLine()
        }

        return count.toInt()
    }

    fun readLottoNumbers(): Lotto {
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
