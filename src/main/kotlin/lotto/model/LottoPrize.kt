package lotto.model

typealias MatchedCount = Int
typealias Prize = Int

class LottoPrize(
    val matchedCount: Int,
    val prize: Prize
) {
    companion object {
        private val prizeMap: Map<MatchedCount, Prize> = mapOf(
            3 to 5000,
            4 to 50000,
            5 to 150000,
            6 to 2000000000,
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
