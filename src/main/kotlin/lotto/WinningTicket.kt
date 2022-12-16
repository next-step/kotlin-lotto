package lotto

class WinningTicket(val lottoRank: LottoRank) {

    companion object {
        fun from(lottoTicket: LottoTicket): WinningTicket {
            require(lottoTicket.lottoStatus.isWinStatus())
            val lottoRank = LottoRank.from(matchCount = lottoTicket.matchCount)
            return WinningTicket(lottoRank = lottoRank)
        }
    }
}
