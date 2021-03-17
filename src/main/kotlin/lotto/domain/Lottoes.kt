package lotto.domain

class Lottoes(
    private val value: List<LottoTicket>
) {
    fun getMyLottoesRanks(winningLotto: WinningLotto): LottoesRank {
        return LottoesRank(
            value.groupBy { lottoTicket ->
                val countOfMatch = lottoTicket.getCountOfMatch(winningLotto.winningNumbers)
                val bonusMatched = lottoTicket.isNumberContains(winningLotto.bonusNumber)
                Rank.valueOf(countOfMatch, bonusMatched)
            }
        )
    }

    fun toList(): List<LottoTicket> {
        return value.toList()
    }
}
