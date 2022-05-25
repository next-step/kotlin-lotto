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
            Rank.FIRST.winningMoney * numberOfCorrects.countNumber(Rank.FIRST.countOfMatch) +
                    Rank.SECOND.winningMoney * numberOfCorrects.countNumber(Rank.SECOND.countOfMatch) +
                    Rank.THIRD.winningMoney * numberOfCorrects.countNumber(Rank.THIRD.countOfMatch) +
                    Rank.FOURTH.winningMoney * numberOfCorrects.countNumber(Rank.FOURTH.countOfMatch)

        return LottoResultDto(
            numberOfCorrects.countNumber(Rank.FIRST.countOfMatch),
            numberOfCorrects.countNumber(Rank.SECOND.countOfMatch),
            numberOfCorrects.countNumber(Rank.THIRD.countOfMatch),
            numberOfCorrects.countNumber(Rank.FOURTH.countOfMatch),
            String.format("%.2f", winningAmount / purchaseAmount.toDouble())
        )
    }

    private fun List<Int>.countNumber(num: Int): Int = count { it == num }
}
