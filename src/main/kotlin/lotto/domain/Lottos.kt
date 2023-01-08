package lotto.domain

@JvmInline
value class Lottos(val value: List<Lotto>) {

    fun matchWinningNumbers(winningNumbers: WinningLotto): Map<Ranking, Int> {
        return value.groupingBy { lotto ->
            Ranking.valueOf(lotto.findWinningCount(winningNumbers))
        }.eachCount()
    }
}
