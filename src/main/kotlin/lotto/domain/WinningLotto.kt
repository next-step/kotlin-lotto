package lotto.domain

data class WinningLotto(
    val winningTicket: LottoTicket,
    val bonusNumber: LottoNumber
) {
    fun matching(lottoTicket: LottoTicket): LottoRank {
        return LottoRank.of(
            matchCount = lottoTicket.matching(winningTicket),
            bonusMatch = lottoTicket.contains(bonusNumber)
        )
    }
}
