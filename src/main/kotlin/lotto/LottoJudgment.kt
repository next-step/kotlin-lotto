package lotto

class LottoJudgment(
    private val lastLottoWinnerTicket: LottoTicket,
    private val bonusNumber: Int = LottoPolicy.NO_BONUS_NUMBER
) {
    fun getRanking(ticket: LottoTicket): LottoWinnerRank {
        val matchNumberCount = matchNumberCount(ticket)
        return getRanking(matchNumberCount, ticket.hasNumber(bonusNumber))
    }

    fun matchNumberCount(ticket: LottoTicket): Int {
        return lastLottoWinnerTicket.matchCountWith(ticket)
    }

    fun getRanking(matchNumberCount: Int, hasBonusNumber: Boolean): LottoWinnerRank {
        return LottoWinnerRank.getRank(matchNumberCount, hasBonusNumber)
    }
}
