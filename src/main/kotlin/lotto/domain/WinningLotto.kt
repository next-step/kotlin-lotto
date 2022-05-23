package lotto.domain

data class WinningLotto(
    val lotto: Lotto,
    val bonusBall: LottoNumber
) {
    companion object {
        fun from(numbers: Set<Int>, bonusBall: Int): WinningLotto {
            return WinningLotto(Lotto.of(numbers), LottoNumber(bonusBall))
        }
    }
}
