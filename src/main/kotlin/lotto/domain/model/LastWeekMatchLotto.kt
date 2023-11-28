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
            require(!numbers.contains(bonusNumber)) {
                "지난주 로또 번호와 보너스 번호는 중복될 수 없습니다. numbers=$numbers, bonusNumber=$bonusNumber"
            }
            return LastWeekMatchLotto(Lotto.valueOf(numbers), LottoNumber.get(bonusNumber))
        }
    }
}
