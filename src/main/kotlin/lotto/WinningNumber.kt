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
            FOURTH_PRIZE_PRICE * numberOfCorrects.countNumber(3) +
                    THIRD_PRIZE_PRICE * numberOfCorrects.countNumber(4) +
                    SECOND_PRIZE_PRICE * numberOfCorrects.countNumber(5) +
                    FIRST_PRIZE_PRICE * numberOfCorrects.countNumber(6)

        return LottoResultDto(
            lottoResult = mapOf(
                "3" to listOf(FOURTH_PRIZE_PRICE, numberOfCorrects.countNumber(3)),
                "4" to listOf(THIRD_PRIZE_PRICE, numberOfCorrects.countNumber(4)),
                "5" to listOf(SECOND_PRIZE_PRICE, numberOfCorrects.countNumber(5)),
                "6" to listOf(FIRST_PRIZE_PRICE, numberOfCorrects.countNumber(6)),
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
