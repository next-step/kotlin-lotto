package lotto.domain

class LottoTickets(private val tickets: List<LottoTicket>) : List<LottoTicket> by tickets {

    init {
        require(tickets.isNotEmpty())
    }

    fun getMatchCount(match: LottoMatch, lastLottoTicket: LottoTicket, lastLottoBonusNumber: Int): Int =
        if (match.withBonus) {
            getMatchCountWithBonus(match, lastLottoTicket, lastLottoBonusNumber)
        } else {
            getMatchCountWithoutBonus(match, lastLottoTicket, lastLottoBonusNumber)
        }

    private fun getMatchCountWithBonus(
        match: LottoMatch,
        lastLottoTicket: LottoTicket,
        lastLottoBonusNumber: Int
    ): Int =
        getMatchTickets(match, lastLottoTicket)
            .filter { it.numbers.contains(lastLottoBonusNumber) }
            .size

    private fun getMatchCountWithoutBonus(
        match: LottoMatch,
        lastLottoTicket: LottoTicket,
        lastLottoBonusNumber: Int
    ): Int =
        getMatchTickets(match, lastLottoTicket)
            .filterNot { it.numbers.contains(lastLottoBonusNumber) }
            .size

    private fun getMatchTickets(match: LottoMatch, lastLottoTicket: LottoTicket): List<LottoTicket> =
        filter { it.numbers.intersect(lastLottoTicket.numbers).size == match.count }
}
