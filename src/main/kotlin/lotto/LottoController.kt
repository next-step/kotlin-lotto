package lotto

class LottoController {
    private lateinit var winningNumbers: List<Int>
    private var money: Int = 0
    private val lottos = mutableListOf<Lotto>()
    fun execute() {
        try {
            input()
            output()
        } catch (e: IllegalArgumentException) {
            error(e)
        }
    }

    private fun getResults(): List<Int> {
        val validator = LottoValidator(winningNumbers)
        val results = MutableList(Lotto.NUMBER_COUNT + 1) { 0 }
        lottos.forEach { results[validator.winningCount(it)]++ }
        return results
    }

    @Throws(IllegalArgumentException::class)
    private fun input() {
        money = InputView.inputMoney().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
        lottos.addAll(LottoStore.buy(money))
        ResultView.printBuyResult(lottos)

        winningNumbers = InputParser.parse(InputView.inputWinningNumbers())
            .map { it.toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE) }

        require(winningNumbers.size == 6) { INPUT_ERROR_MESSAGE }
    }

    private fun output() {
        val results = getResults()
        val earningRate = LottoCalculator.earningRate(results, money)
        ResultView.printLottoResult(results, earningRate, earningRate.toProfitState())
    }

    private fun error(error: Throwable) = ResultView.printMessage(error.message ?: "")

    companion object {
        private const val INPUT_ERROR_MESSAGE = "입력 값이 잘못되었습니다"
    }
}
