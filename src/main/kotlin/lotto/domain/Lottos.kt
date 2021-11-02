package lotto.domain

class Lottos(
    _value: List<Lotto>,
) {
    val value = ArrayList(_value)

    fun matchWinningNumber(winningNumbers: List<LottoNumber>, bonusNumber: Int): Map<Rank, Int> {
        return value
            .map {
                Rank.valueOf(it.matchWinningNumber(winningNumbers), it.matchBonusNumber(bonusNumber))
            }
            .groupingBy { it }
            .eachCount()
    }
}
