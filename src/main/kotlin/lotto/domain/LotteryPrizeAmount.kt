package lotto.domain

enum class LotteryPrizeAmount(val winNum: Int, val prize: Int, val bonusMatch: Boolean) {
    MISS(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    ;

    companion object {
        fun getWinningPrize(winNum: Int, bonusMatch: Boolean = false): LotteryPrizeAmount {
            return values().find { it.winNum == winNum && it.bonusMatch == bonusMatch} ?: MISS
        }
    }
}
