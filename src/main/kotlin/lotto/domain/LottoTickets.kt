package lotto.domain

class LottoTickets(private val tickets: List<LottoTicket>) : List<LottoTicket> by tickets {

    init {
        require(tickets.isNotEmpty())
    }

    fun getMatchCount(match: LottoMatch, lastNumbers: LottoLastNumbers): Int =
        if (match.withBonus) {
            getMatchCountWithBonus(match, lastNumbers)
        } else {
            getMatchCountWithoutBonus(match, lastNumbers)
        }

    private fun getMatchCountWithBonus(match: LottoMatch, lastNumbers: LottoLastNumbers): Int =
        getMatchTickets(match, lastNumbers)
            .filter { it.numbers.contains(lastNumbers.bonus) }
            .size

    private fun getMatchCountWithoutBonus(match: LottoMatch, lastNumbers: LottoLastNumbers): Int =
        getMatchTickets(match, lastNumbers)
            .filterNot { it.numbers.contains(lastNumbers.bonus) }
            .size

    private fun getMatchTickets(match: LottoMatch, lastNumbers: LottoLastNumbers): List<LottoTicket> =
        filter { it.numbers.intersect(lastNumbers).size == match.count }
}
