package lotto.domain

data class WinningLotto(
    val winningNumbers: List<LottoNumber>,
    val bonusNumber: LottoNumber
) {
    init {
        checkWinningNumbersContainsBonusNumber()
    }

    private fun checkWinningNumbersContainsBonusNumber() {
        if (winningNumbers.contains(bonusNumber)) throw IllegalArgumentException("보너스 숫자가 이미 당첨번호에 존재합니다.")
    }
}
