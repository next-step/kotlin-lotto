package lotto.domain

data class WinningLotto(
    val winningNumbers: LottoTicket,
    val bonusNumber: LottoNumber
) {
    init {
        checkWinningNumbersContainsBonusNumber()
    }

    fun getRankOfTicket(lottoTicket: LottoTicket): Rank {
        val countOfMatch = getCountOfMatch(lottoTicket)
        val bonusMatched = isNumberContains(lottoTicket)
        return Rank.valueOf(countOfMatch, bonusMatched)
    }

    private fun getCountOfMatch(lottoTicket: LottoTicket): Int {
        return lottoTicket.value.count { lottoNumber ->
            winningNumbers.value.contains(lottoNumber)
        }
    }

    private fun isNumberContains(lottoTicket: LottoTicket): Boolean {
        return lottoTicket.value.contains(bonusNumber)
    }

    private fun checkWinningNumbersContainsBonusNumber() {
        require(!winningNumbers.isNumberContains(bonusNumber)) { "보너스 숫자가 이미 당첨번호에 존재합니다." }
    }
}
