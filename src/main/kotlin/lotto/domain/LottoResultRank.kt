package lotto.domain

import java.util.Arrays
import java.util.stream.Collectors

enum class LottoResultRank(val matchedCount: Int, val prizeMoney: Long) {
    MISSED(0, 0L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    FIRST(6, 2_000_000_000L),
    ;

    companion object {
        private val rankMap = Arrays.stream(values())
            .collect(Collectors.toMap({ rank: LottoResultRank -> rank.matchedCount }) { rank: LottoResultRank -> rank })

        fun getRank(matchedCount: Int): LottoResultRank {
            return rankMap.getOrDefault(matchedCount, MISSED)
        }
    }
}
