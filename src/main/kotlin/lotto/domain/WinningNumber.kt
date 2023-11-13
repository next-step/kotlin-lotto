package lotto.domain

data class WinningNumber(private var _winningNumberList: List<LottoNumber>) : AbstractLottoTicket(_winningNumberList) {
    fun getRank(lottoTicket: LottoTicket): Rank {
        val count = lottoTicket.lottoNumberList.count { it in _winningNumberList }

        return Rank.values().find { it.hitCount == count } ?: Rank.LastPlace
    }
}
