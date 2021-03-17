package lotto.domain

class Lottoes(
    private val value: List<LottoTicket>
) {
    fun getMyLottoesRanks(winningLotto: WinningLotto): LottoesRank {
        return LottoesRank(
            value.groupBy { lottoTicket ->
                winningLotto.getTicketRank(lottoTicket)
            }
        )
    }

    fun toList(): List<LottoTicket> {
        return value.toList()
    }
}
