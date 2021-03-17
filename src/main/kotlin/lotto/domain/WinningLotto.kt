package lotto.domain

data class WinningLotto(
    val winningNumbers: LottoTicket,
    val bonusNumber: LottoNumber
) {
    init {
        checkWinningNumbersContainsBonusNumber()
    }

    fun getTicketRank(lottoTicket: LottoTicket): Rank {
        val countOfMatch = getCountOfMatch(lottoTicket)
        val bonusMatches = isBonusNumberMatch(lottoTicket)
        return Rank.valueOf(countOfMatch, bonusMatches)
    }

    private fun getCountOfMatch(lottoTicket: LottoTicket): Int {
        return lottoTicket.value.count { lottoNumber ->
            winningNumbers.value.contains(lottoNumber)
        }
    }

    private fun isBonusNumberMatch(lottoTicket: LottoTicket): Boolean {
        return lottoTicket.value.contains(bonusNumber)
    }

    private fun checkWinningNumbersContainsBonusNumber() {
        if (winningNumbers.value.contains(bonusNumber)) throw IllegalArgumentException("보너스 숫자가 이미 당첨번호에 존재합니다.")
    }
}
