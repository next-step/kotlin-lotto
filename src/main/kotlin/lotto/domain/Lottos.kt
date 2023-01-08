package lotto.domain

@JvmInline
value class Lottos(val value: List<Lotto>) {

    fun matchWinningNumbers(winningNumbers: WinningLotto, bonusNumber: Int): Map<Ranking, Int> {
        return value.groupingBy { lotto ->
            val findWinningCount = lotto.findWinningCount(winningNumbers)
            val isBonus = winningNumbers.isMatchBonus(bonusNumber)

            Ranking.valueOf(findWinningCount, isBonus)
        }.eachCount()
    }
}
