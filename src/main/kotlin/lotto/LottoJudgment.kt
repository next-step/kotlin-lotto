package lotto

class LottoJudgment(
    private val lastLottoWinnerTicket: LottoTicket
) {

    fun getRanking(ticket: LottoTicket): LottoWinnerRank {
        val matchNumberCount = matchNumberCount(ticket)
        return getRanking(matchNumberCount)
    }

    fun matchNumberCount(ticket: LottoTicket): Int {
        return lastLottoWinnerTicket.matchCountWith(ticket)
    }

    fun getRanking(matchNumberCount: Int): LottoWinnerRank {
        return LottoWinnerRank.getRank(matchNumberCount)
    }
}
