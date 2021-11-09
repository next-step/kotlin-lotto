package lotto.domain

class Lottos(
    value: List<Lotto>,
) {
    val value = value.toList()

    fun matchWinningNumber(winningNumber: WinningNumber): Map<Rank, Int> {
        return value
            .map {
                Rank.valueOf(
                    it.matchWinningNumber(winningNumber),
                    it.matchBonusNumber(winningNumber)
                )
            }
            .groupingBy { it }
            .eachCount()
    }
}
