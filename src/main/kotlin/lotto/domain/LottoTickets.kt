package lotto.domain

data class LottoTickets(private val tickets: List<LottoTicket>) : List<LottoTicket> by tickets {

    init {
        require(isNotEmpty())
    }

    fun getLottoStatistics(lastNumbers: LottoLastNumbers): LottoStatistics =
        LottoStatistics(
            this
                .map { it.getMatch(lastNumbers) }
                .groupBy { it }
                .map { it.key to it.value.size }
                .toMap()
        )

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
                matchTickets.filter { it.contains(lastNumbers.bonus) }
            } else {
                matchTickets.filterNot { it.contains(lastNumbers.bonus) }
            }
        }.size
    }

    private fun getMatchTickets(match: LottoMatch, lastNumbers: LottoLastNumbers): List<LottoTicket> =
        filter { it.intersect(lastNumbers).size == match.count }
}
