package lotto.domain

class Lottoes(
    private val value: List<LottoTicket>
) {
    fun getMyLottoesRanks(winningLotto: WinningLotto): LottoesRank {
        return LottoesRank(
            value.groupBy { lottoTicket ->
                val countOfMatch = winningLotto.getCountOfMatch(lottoTicket)
                val bonusMatched = winningLotto.isNumberContains(lottoTicket)
                Rank.valueOf(countOfMatch, bonusMatched)
            }.mapValues {
                it.value.size
            }
        )
    }

    fun toList(): List<LottoTicket> {
        return value.toList()
    }
}
