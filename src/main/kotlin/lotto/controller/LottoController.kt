package lotto.controller

import lotto.domain.InputParser
import lotto.domain.LottoCalculator
import lotto.domain.LottoStore
import lotto.domain.model.InputResult
import lotto.domain.model.Lotto
import lotto.domain.model.LottoResult
import lotto.domain.model.Lottos
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
        val money = InputView.inputMoney().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
        val lottos = Lottos(mutableListOf<Lotto>().apply { addAll(LottoStore.buy(money)) })
        ResultView.printBuyResult(lottos)

        val winningNumbers = InputParser.parse(InputView.inputWinningNumbers())
            .map { it.toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE) }

        val bonus = InputView.inputBonusBall().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)

        require(winningNumbers.size == Lotto.NUMBER_COUNT) { INPUT_ERROR_MESSAGE }
        return InputResult(lottos, SelectedBalls(WinningBalls(winningNumbers), bonus), money)
    }

    private fun output(lottos: Lottos, selectedBalls: SelectedBalls, money: Int) {
        val results = getResults(lottos, selectedBalls)
        val earningRate = LottoCalculator.earningRate(results, money)
        ResultView.printLottoResult(results, earningRate, earningRate.toProfitState())
    }

    private fun error(error: Throwable) = ResultView.printMessage(error.message ?: "")

    private fun getResults(lottos: Lottos, selectedBalls: SelectedBalls): List<LottoResult> {
        val results = Prize.values().map { LottoResult(0, it) }.toMutableList()
        lottos.items.forEach {
            val prize = Prize.from(selectedBalls, it)
            val index = Prize.indexOf(prize.matches, prize.bonus)
            results[index] = LottoResult(results[index].count + 1, prize)
        }
        return results
    }

    companion object {
        private const val INPUT_ERROR_MESSAGE = "입력 값이 잘못되었습니다"
    }
}
