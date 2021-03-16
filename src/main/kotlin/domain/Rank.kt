package domain

enum class Rank(val matchCount: Int, private val price: Int) {
    FIRST(6, 200_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    fun matchCount(lotteryNumbers: LotteryNumbers, winnerLottery: WinnerLottery): Int {
        return lotteryNumbers.numbers.filter { winnerLottery.numbers.numbers.contains(it) }.count()
    }

    companion object {
        fun isInTheRank(count: Int): Boolean {
            return values().filter { count == it.matchCount }.any()
        }
    }
}
