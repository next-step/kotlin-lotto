package nextstep.mission.lotto

private const val LOTTO_PRICE = 1000

class Lottos(val lottos: List<Lotto>) {
    constructor(lottoPrice: Int) : this(createLottos(lottoPrice / LOTTO_PRICE))

    fun checkWinningNumbers(winningNumbers: List<Int>): WinningResult {
        tailrec fun checkWinningNumbers(
            winningNumbers: List<Int>,
            lottos: MutableList<Lotto>,
            result: WinningResult
        ): WinningResult = when {
            lottos.isEmpty() -> result
            else -> {
                val lotto: Lotto = lottos.removeFirst()
                val winningCount: Int = lotto.checkWinningNumbers(winningNumbers = winningNumbers)
                result.increase(winningCount)
                checkWinningNumbers(winningNumbers, lottos, result)
            }
        }
        return checkWinningNumbers(winningNumbers, this.lottos.toMutableList(), WinningResult())
    }

    companion object {
        private fun createLottos(count: Int, lottos: List<Lotto> = emptyList()): List<Lotto> = when (lottos.size) {
            count -> lottos
            else -> {
                try {
                    val numbers: List<Int> = NumberFactory.create()
                    createLottos(count, lottos + Lotto(numbers))
                } catch (e: Exception) {
                    createLottos(count, lottos)
                }
            }
        }
    }
}
