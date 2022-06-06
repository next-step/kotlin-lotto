package lotto.domain

enum class Rank(val prize: Long, private val matchCount: Int) {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3),
    FAIL(0, -1);

    companion object {
        fun determineLottoTicket(winLottoTicket: LottoTicket, lottoTickets: List<LottoTicket>): List<Rank> {
            val matchCounts = lottoTickets.map { lottoTicket ->
                (lottoTicket + winLottoTicket).lottoNums
                    .groupBy { it }
                    .filter { it.value.size > 1 }
                    .flatMap { it.value }
                    .distinct()
                    .count()
            }

            return matchCounts.map { getInstance(it) }
        }

        private fun getInstance(matchCount: Int): Rank {
            return when (matchCount) {
                6 -> FIRST
                5 -> SECOND
                4 -> THIRD
                3 -> FOURTH
                else -> FAIL
            }
        }
    }
}
