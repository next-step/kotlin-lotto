package lotto.model

enum class LottoPrize(val matchCount: Int, val prizeAmount: Int, val hasBonus: Boolean = false) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 150_000),
    FIVE_BONUS(5, 30_000_000, true), // 보너스 볼 일치 추가
    SIX(6, 2_000_000_000),
    NONE(0, 0),
    ;

    companion object {
        private val lottoPrizeMap = entries.associateBy { it.matchCount to it.hasBonus }
        private val lottoPrizes = entries.toList().sortedByDescending { it.prizeAmount }

        fun fromMatchCount(
            matchCount: Int,
            hasBonus: Boolean,
        ): LottoPrize = lottoPrizeMap[matchCount to hasBonus] ?: NONE

        fun getLottoPrizes(): List<LottoPrize> = lottoPrizes
    }
}
