package lotto.controller

import lotto.domain.LottoCalculator
import lotto.domain.LottoStore
import lotto.domain.ManualNumbers
import lotto.domain.model.Count
import lotto.domain.model.InputResult
import lotto.domain.model.LottoNumber
import lotto.domain.model.LottoResult
import lotto.domain.model.Lottos
import lotto.domain.model.Money
import lotto.domain.model.Prize
import lotto.domain.model.SelectedBalls
import lotto.domain.model.WinningBalls
import lotto.domain.model.toProfitState
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun execute() {
        try {
            val inputResult = input()
            output(inputResult.lottos, inputResult.selectedBalls, inputResult.money)
        } catch (e: IllegalArgumentException) {
            error(e)
        }
    }

    @Throws(IllegalArgumentException::class)
    private fun input(): InputResult {
        val money = inputMoney()
        val manualNumbers = inputManuals()

        val lottos = Lottos(LottoStore.buy(money, manualNumbers))
        ResultView.printBuyResult(Count(manualNumbers.size), Count(lottos.items.size - manualNumbers.size), lottos)

        val winningBalls = inputWinningNumbers()

        val bonus = InputView.inputBonusBall()
        return InputResult(lottos, SelectedBalls(winningBalls, LottoNumber.from(bonus)), money)
    }

    private fun inputMoney(): Money {
        val input = InputView.inputMoney()
        return Money(input)
    }

    private fun inputManuals(): List<ManualNumbers> {
        val manualCountInput = InputView.inputManualCount()

        val manualNumbers = InputView.inputManualNumbers(Count(manualCountInput)).map {
            it.map(LottoNumber::from)
        }.map(::ManualNumbers)
        return manualNumbers
    }

    private fun inputWinningNumbers(): WinningBalls {
        val winningNumbers = InputView.inputWinningNumbers().map(LottoNumber::from)
        return WinningBalls(winningNumbers)
    }

    private fun output(lottos: Lottos, selectedBalls: SelectedBalls, money: Money) {
        val results = getResults(lottos, selectedBalls)
        val earningRate = LottoCalculator.earningRate(results, money)
        ResultView.printLottoResult(results, earningRate, earningRate.toProfitState())
    }

    private fun error(error: Throwable) = ResultView.printMessage(error.message ?: "")

    private fun getResults(lottos: Lottos, selectedBalls: SelectedBalls): List<LottoResult> {
        val results = Prize.values().map { LottoResult(Count(0), it) }.toMutableList()
        lottos.items.forEach {
            val prize = Prize.from(selectedBalls, it)
            val index = Prize.indexOf(prize.matches, prize.bonus)
            results[index] = LottoResult(Count(results[index].count.value + 1), prize)
        }
        return results
    }
}
