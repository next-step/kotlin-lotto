package lotto

class WinningNumber(private val lastWeekWinningNumbers: List<Int>) {
    fun match(purchaseAmount: Int, lottos: List<Lotto>): LottoResultDto {
        val numberOfCorrects = mutableListOf<Int>()

        lottos.forEach {
            it
                .mapIndexed { index, value -> lastWeekWinningNumbers[index] == value }
                .count { value -> value }
                .also { numberOfCorrect -> numberOfCorrects.add(numberOfCorrect) }
        }

        val winningAmount =
            FOURTH_PRIZE_PRICE * numberOfCorrects.countNumber(MatchCount.FOURTH_PRIZE) +
                    THIRD_PRIZE_PRICE * numberOfCorrects.countNumber(MatchCount.THIRD_PRIZE) +
                    SECOND_PRIZE_PRICE * numberOfCorrects.countNumber(MatchCount.SECOND_PRIZE) +
                    FIRST_PRIZE_PRICE * numberOfCorrects.countNumber(MatchCount.FIRST_PRIZE)

        return LottoResultDto(
            lottoResult = mapOf(
                MatchCount.FOURTH_PRIZE.toString() to listOf(FOURTH_PRIZE_PRICE, numberOfCorrects.countNumber(MatchCount.FOURTH_PRIZE)),
                MatchCount.THIRD_PRIZE.toString() to listOf(THIRD_PRIZE_PRICE, numberOfCorrects.countNumber(MatchCount.THIRD_PRIZE)),
                MatchCount.SECOND_PRIZE.toString() to listOf(SECOND_PRIZE_PRICE, numberOfCorrects.countNumber(MatchCount.SECOND_PRIZE)),
                MatchCount.FIRST_PRIZE.toString() to listOf(FIRST_PRIZE_PRICE, numberOfCorrects.countNumber(MatchCount.FIRST_PRIZE)),
            ),
            rateOfReturn = String.format("%.2f", winningAmount / purchaseAmount.toDouble())
        )
    }

    private fun List<Int>.countNumber(num: Int): Int = count { it == num }

    companion object {
        private const val FOURTH_PRIZE_PRICE = 5000
        private const val THIRD_PRIZE_PRICE = 50_000
        private const val SECOND_PRIZE_PRICE = 1_500_000
        private const val FIRST_PRIZE_PRICE = 2_000_000_000
    }
}
