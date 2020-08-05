package model

data class PrizeEarn(val lottoPrize: LottoPrize, val count: Int = 0) {
    val prizeMoney
        get() = lottoPrize.prizeMoney
    val grade
        get() = lottoPrize.grade

    val totalPrizeMoney
        get() = lottoPrize.prizeMoney * count
}
