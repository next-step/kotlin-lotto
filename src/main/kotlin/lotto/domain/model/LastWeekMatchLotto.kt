package lotto.domain.model

data class LastWeekMatchLotto(
    val numbers: Lotto,
    val bonusNumber: LottoNumber,
) {
    fun match(lotto: Lotto): Rank {
        val matchCount = lotto.matchCount(numbers)
        val isMatchBonusNumber = lotto.contains(bonusNumber)
        return Rank.valueOf(matchCount, isMatchBonusNumber)
    }

    companion object {
        fun valueOf(numbers: Iterable<Int>, bonusNumber: Int): LastWeekMatchLotto {
            return LastWeekMatchLotto(Lotto.valueOf(numbers), LottoNumber.get(bonusNumber))
        }
    }
}
