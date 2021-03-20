package lotto.domain.result

enum class LottoRank(val matchCount: Int, val hasBonus: Boolean, val prize: Long) {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0L);

    companion object {
        private val matcher = values().map { Pair(it, 0) }.toMap()

        private fun of(matchInfo: MatchInfo): LottoRank {
            return values().find { matchInfo.matchCount == it.matchCount && matchInfo.hasBonus == it.hasBonus } ?: NONE
        }

        fun rank(matchInfos: List<MatchInfo>): LottoResult {
            val result = matcher.toMutableMap()
            matchInfos.forEach { result[of(it)] = result[of(it)]!! + 1 }
            return LottoResult(result)
        }
    }
}
