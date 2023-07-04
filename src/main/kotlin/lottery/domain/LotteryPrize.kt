package lottery.domain

enum class LotteryPrize(val correctCount: Int, val rewardMoney: Int) {
    NONE(0, 0),
    FORTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000), ;

    companion object {
        fun get(correctCount: Int): LotteryPrize? {
            return LotteryPrize.values().find { it.correctCount == correctCount }
        }
    }
}
