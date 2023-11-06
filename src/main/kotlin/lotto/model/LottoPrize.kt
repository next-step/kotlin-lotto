package lotto.model

private typealias MatchedCount = Int
private typealias Prize = Int

class LottoPrize(
    val prize: Prize
) {
    companion object {
        private val prizeMap: Map<MatchedCount, Prize> = mapOf(
            3 to 5000,
            4 to 50000,
            5 to 150000,
            6 to 2000000000,
        )

        fun create(matchedNumber: Int): LottoPrize {
            val prize = prizeMap[matchedNumber] ?: 0

            return LottoPrize(prize)
        }
    }
}
