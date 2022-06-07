package lotto.domain

enum class Rank(val prize: Long, val matchCount: Int) {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3),
    FAIL(0, -1);

    companion object {
        fun determineLottoTicket(winNums: LottoTicket, lottoTicket: LottoTicket): Rank {
            val matchingCount = lottoTicket.matchingCount(winNums)

            return getInstance(matchingCount)
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
