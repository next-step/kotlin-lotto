package lotto

class LottoJudgment(
    private val lastLottoWinnerTicket: LottoTicket
) {

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
