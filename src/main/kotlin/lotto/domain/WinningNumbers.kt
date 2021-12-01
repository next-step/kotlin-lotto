package lotto.domain

class WinningNumbers(winningNumbers: List<Int>, bonusNumber: Int) {
    val winningNumbers: List<LottoNumber> = winningNumbers.map(LottoNumber.Companion::from)
    val bonusNumber: LottoNumber = LottoNumber.from(bonusNumber).also(this::validateInWinningNumbers)

    private fun validateInWinningNumbers(bonusNumber: LottoNumber) {
        require(!winningNumbers.contains(bonusNumber)) {
            "당첨 번호안에 보너스 번호가 포함되어 있습니다."
        }
    }
}
