package lotto.domain

class WinningNumber(private val lastWeekWinningNumbers: List<Int>) {
    fun match(purchaseAmount: Int, lottos: List<Lotto>): LottoResultDto {
        val numberOfCorrectsByRank = lottos.map {
            val numberOfCorrect = it
                .mapIndexed { index, value -> lastWeekWinningNumbers[index] == value }
                .count { value -> value }

            val rank = Rank.find(numberOfCorrect)

            NumberOfCorrectsByRank(numberOfCorrect, rank)
        }

        val winningAmount = numberOfCorrectsByRank.sumOf {
            val (_, rank) = it
            rank.winningMoney
        }

        return LottoResultDto(
            numberOfCorrectsByRank.countNumber(Rank.FIRST.numberOfCorrect),
            numberOfCorrectsByRank.countNumber(Rank.SECOND.numberOfCorrect),
            numberOfCorrectsByRank.countNumber(Rank.THIRD.numberOfCorrect),
            numberOfCorrectsByRank.countNumber(Rank.FOURTH.numberOfCorrect),
            String.format("%.2f", winningAmount / purchaseAmount.toDouble())
        )
    }

    private fun List<NumberOfCorrectsByRank>.countNumber(countOfMatch: Int): Int = count {
        val (numberOfCorrect) = it
        numberOfCorrect == countOfMatch
    }
}
