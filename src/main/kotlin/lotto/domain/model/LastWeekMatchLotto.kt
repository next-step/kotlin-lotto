package lotto.domain.model

data class LastWeekMatchLotto(
    val numbers: Lotto,
    val bonusNumber: LottoNumber,
) {
    companion object {
        fun valueOf(numbers: Iterable<Int>, bonusNumber: Int): LastWeekMatchLotto {
            return LastWeekMatchLotto(Lotto.valueOf(numbers), LottoNumber.get(bonusNumber))
        }
    }
}
