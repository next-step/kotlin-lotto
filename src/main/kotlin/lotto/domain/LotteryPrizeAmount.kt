package lotto.domain

enum class LotteryPrizeAmount(val winNum: Int, val prize: Int) {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    companion object {
        fun getWinningPrize(winNum: Int, bonusMatch: Boolean = false): LotteryPrizeAmount {
            val lotteryPrizeAmount = values().find { it.winNum == winNum } ?: MISS
            if (lotteryPrizeAmount == THIRD && bonusMatch) return SECOND
            return lotteryPrizeAmount
        }
    }
}
