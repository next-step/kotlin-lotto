package lotto.domain

class Lottos(
    private val value: List<Lotto>,
) {
    fun matchWinningNumber(winningNumbers: List<LottoNumber>): Map<Rank, Int> {
        return value.map { it.matchWinningNumber(winningNumbers) }
            .map { Rank.valueOf(it) }
            .groupingBy { it }
            .eachCount()
    }
}
