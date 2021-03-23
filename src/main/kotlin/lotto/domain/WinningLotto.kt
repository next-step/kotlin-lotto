package lotto.domain

data class WinningLotto(
    val winningNumbers: LottoTicket,
    val bonusNumber: LottoNumber
) {
    init {
        checkWinningNumbersContainsBonusNumber()
    }

    fun getRankOfTicket(lottoTicket: LottoTicket): Rank {
        val countOfMatch = lottoTicket.getCountOfMatch(winningNumbers)
        val bonusMatched = lottoTicket.isNumberContains(bonusNumber)
        return Rank.valueOf(countOfMatch, bonusMatched)
    }

    private fun checkWinningNumbersContainsBonusNumber() {
        require(!winningNumbers.isNumberContains(bonusNumber)) { "보너스 숫자가 이미 당첨번호에 존재합니다." }
    }
}
