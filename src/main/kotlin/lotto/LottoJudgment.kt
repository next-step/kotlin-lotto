package lotto

import lotto.money.Money

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

    fun getPrice(matchNumberCount: Int): Money {
        val rank = LottoWinnerPolicy.getRank(matchNumberCount)
        return rank.price
    }
}
