package lotto

class LottoJudgment(
    private val lastLottoWinnerTicket: LottoTicket
) {

    fun getRanking(ticket: LottoTicket): LottoWinnerRank {
        val matchNumberCount = matchNumberCount(ticket)
        return getRanking(matchNumberCount)
    }

    fun matchNumberCount(ticket: LottoTicket): Int {
        var matchNumberCount = 0
        for (number in ticket.numbers) {
            if (lastLottoWinnerTicket.numbers.contains(number)) {
                matchNumberCount++
            }
        }
        return matchNumberCount
    }

    fun getRanking(matchNumberCount: Int): LottoWinnerRank {
        return LottoWinnerRank.getRank(matchNumberCount)
    }
}
