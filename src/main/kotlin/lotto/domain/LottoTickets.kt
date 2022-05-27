package lotto.domain

class LottoTickets(private val tickets: List<LottoTicket>) : List<LottoTicket> by tickets {

    init {
        require(tickets.isNotEmpty())
    }

    fun getMatchResult(lastNumbers: LottoLastNumbers): Map<LottoMatch, MatchCount> {
        return mutableMapOf<LottoMatch, MatchCount>().apply {
            LottoMatch.values().forEach {
                put(it, getMatchCount(it, lastNumbers))
            }
        }
    }

    private fun getMatchCount(match: LottoMatch, lastNumbers: LottoLastNumbers): Int {
        return getMatchTickets(match, lastNumbers).let { matchTickets ->
            if (match.withBonus) {
                matchTickets.filter { it.numbers.contains(lastNumbers.bonus) }
            } else {
                matchTickets.filterNot { it.numbers.contains(lastNumbers.bonus) }
            }
        }.size
    }

    private fun getMatchTickets(match: LottoMatch, lastNumbers: LottoLastNumbers): List<LottoTicket> =
        filter { it.numbers.intersect(lastNumbers).size == match.count }
}
