package lotto.domain

enum class LotteryPrizeAmount(val winNum: Int, val prize: Int) {
    MISS(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ;

    companion object {
        fun getWinningPrize(winNum: Int): Int {
            return values().find { it.winNum == winNum }?.prize ?: 0
        }
    }
}
