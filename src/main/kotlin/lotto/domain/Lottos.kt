package lotto.domain

class Lottos(
    value: List<Lotto>,
) {
    val value = value.toList()

    fun matchWinningNumber(winningNumbers: LottoNumbers, bonusNumber: Int): Map<Rank, Int> {
        return value
            .map {
                Rank.valueOf(it.matchWinningNumber(winningNumbers), it.matchBonusNumber(bonusNumber))
            }
            .groupingBy { it }
            .eachCount()
    }
}
