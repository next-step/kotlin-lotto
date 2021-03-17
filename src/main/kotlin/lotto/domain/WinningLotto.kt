package lotto.domain

data class WinningLotto(
    val winningNumbers: LottoTicket,
    val bonusNumber: LottoNumber
) {
    init {
        checkWinningNumbersContainsBonusNumber()
    }

    private fun checkWinningNumbersContainsBonusNumber() {
        require(!winningNumbers.value.contains(bonusNumber)) { "보너스 숫자가 이미 당첨번호에 존재합니다." }
    }
}
