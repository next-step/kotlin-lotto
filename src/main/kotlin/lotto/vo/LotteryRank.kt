package lotto.vo

enum class LotteryRank(val matchCount: Int, val rewardMoney: Int) {

    NONE(0, 0),
    FOUR_PLACE(3, 5_000),
    THIRD_PLACE(4, 50_000),
    TWO_PLACE(5, 1_500_000),
    BONUS_TWO_PLACE(5, 30_000_000),
    ONE_PLACE(6, 2_000_000_000);

    companion object {

        fun of(count: Int): LotteryRank = LotteryRank.values().find { it.matchCount == count } ?: NONE
    }
}
