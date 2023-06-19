package lotto

class LottoController {
    fun execute() {
        try {
            val inputResult = input()
            output(inputResult.lottos, inputResult.winningNumbers, inputResult.money)
        } catch (e: IllegalArgumentException) {
            error(e)
        }
    }

    @Throws(IllegalArgumentException::class)
    private fun input(): InputResult {
        val money = InputView.inputMoney().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
        val lottos = mutableListOf<Lotto>().apply { addAll(LottoStore.buy(money)) }
        ResultView.printBuyResult(lottos)

        val winningNumbers = InputParser.parse(InputView.inputWinningNumbers())
            .map { it.toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE) }

        require(winningNumbers.size == Lotto.NUMBER_COUNT) { INPUT_ERROR_MESSAGE }
        return InputResult(lottos, winningNumbers, money)
    }

    private fun output(lottos: List<Lotto>, winningNumbers: List<Int>, money: Int) {
        val results = getResults(lottos, winningNumbers)
        val earningRate = LottoCalculator.earningRate(results, money)
        ResultView.printLottoResult(results, earningRate, earningRate.toProfitState())
    }

    private fun error(error: Throwable) = ResultView.printMessage(error.message ?: "")

    private fun getResults(lottos: List<Lotto>, winningNumbers: List<Int>): List<LottoResult> {
        val validator = LottoValidator(winningNumbers)
        val results = Lotto.prizes.map { LottoResult(0, it) }.toMutableList()
        lottos.forEach {
            val index = validator.winningCount(it)
            val (count, prize) = results[index]
            results[index] = LottoResult(count + 1, prize)
        }
        return results
    }

    companion object {
        private const val INPUT_ERROR_MESSAGE = "입력 값이 잘못되었습니다"
    }
}
