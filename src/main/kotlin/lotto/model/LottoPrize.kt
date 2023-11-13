package lotto.model

import lotto.utils.MatchedCount
import lotto.utils.Prize

class LottoPrize(
    val matchedCount: Int,
    val prize: Prize
) {
    companion object {
        private val prizeMap: Map<MatchedCount, Prize> = mapOf(
            3 to 5_000,
            4 to 50_000,
            5 to 150_000,
            6 to 2_000_000_000,
        )

        fun getPrize(matchedCount: MatchedCount): Prize {
            return prizeMap[matchedCount] ?: 0
        }

        fun create(matchedCount: Int): LottoPrize {
            val prize = getPrize(matchedCount)

            return LottoPrize(matchedCount, prize)
        }
    }
}
