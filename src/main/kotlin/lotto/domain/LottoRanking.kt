package lotto.domain

enum class LottoRanking(val count: Int, val reward: Long) {
    RANK_1(6, 2_000_000_000L),
    RANK_2(5, 150_000_000L),
    RANK_3(4, 50_000L),
    RANK_4(3, 5_000L),
    NO_RANK(-1, 0)
    ;

    companion object {

        fun from(count: Int): LottoRanking {
            return values().firstOrNull { isCountMatch(it, count) } ?: NO_RANK
        }

        private fun isCountMatch(ranking: LottoRanking, count: Int) = (ranking.count == count)
    }
}
