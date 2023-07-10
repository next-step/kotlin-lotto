package lotto.domain

class WinningLotto(
    private val winningNumbers: List<LottoNumber>,
    private val bonusNumber: LottoNumber
) {
    companion object {
        fun from(winningNumbers: List<Int>, bonusNumber: Int): WinningLotto {
            return WinningLotto(
                winningNumbers.map { LottoNumber(it) },
                LottoNumber(bonusNumber)
            )
        }
    }
}
