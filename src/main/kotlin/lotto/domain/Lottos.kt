package lotto.domain

class Lottos(
    private val value: List<Lotto>,
) {
    fun matchWinningNumber(winningNumbers: List<Int>): Map<Rank, Int> {
        return value.map { it.matchWinningNumber(winningNumbers) }
            .map { Rank.valueOf(it) }
            .groupingBy { it }
            .eachCount()
    }
}
