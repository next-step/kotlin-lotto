package lotto.domain

class Lottos(
    private val values: List<Lotto>,
) {
    val size = values.size
    val cost = size * Lotto.PRICE

    fun calculateResult(winningNumbers: WinningNumbers): LottosResult {
        var numberOfFirst = DEFAULT_VALUE
        var numberOfThird = DEFAULT_VALUE
        var numberOfFourth = DEFAULT_VALUE
        var numberOfFifth = DEFAULT_VALUE

        values.forEach { lotto ->
            val numberOfMatchedNumbers = lotto.calculateNumberOfMatchedNumbers(winningNumbers)
            when (numberOfMatchedNumbers) {
                LottoPrize.FIRST.matchCount -> numberOfFirst++
                LottoPrize.THIRD.matchCount -> numberOfThird++
                LottoPrize.FOURTH.matchCount -> numberOfFourth++
                LottoPrize.FIFTH.matchCount -> numberOfFifth++
            }
        }

        return LottosResult(
            numberOfFirst = numberOfFirst,
            numberOfThird = numberOfThird,
            numberOfFourth = numberOfFourth,
            numberOfFifth = numberOfFifth,
        )
    }

    override fun toString(): String {
        return values.joinToString("\n")
    }

    companion object {
        private const val DEFAULT_VALUE = 0
    }
}
