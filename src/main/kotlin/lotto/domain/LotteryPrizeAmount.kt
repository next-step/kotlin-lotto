package lotto.domain

enum class LotteryPrizeAmount(val winNum: Int, val prize: Int) {
    ZERO_WIN(0, 0),
    ONE_WIN(1, 0),
    TWO_WIN(2, 0),
    THREE_WIN(3, 5000),
    FOUR_WIN(4, 50000),
    FIVE_WIN(5, 1500000),
    SIX_WIN(6, 2000000000),
    ;

    companion object {
        fun getWinningPrize(winNum: Int): Int {
            return values().find { it.winNum == winNum }?.prize ?: 0
        }
    }
}
