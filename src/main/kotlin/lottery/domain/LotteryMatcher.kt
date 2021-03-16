package lottery.domain

class LotteryMatcher(private val winnerLottery: WinnerLottery, private val createdLotteries: List<Lottery>) {
    fun match(): HashMap<Int, Int> {
        val result = HashMap<Int, Int>()

        createdLotteries.map {
            val count = matchCount(it.lotteryNumbers)

            if (Rank.isInTheRank(count)) {
                addMatchCount(result, count)
            }
        }

        return result
    }

    private fun addMatchCount(result: HashMap<Int, Int>, count: Int) {
        result[count] = result.getOrDefault(count, WinnerLottery.DEFAULT_MATCH_COUNT) + WinnerLottery.ADD_COUNT_VALUE
    }

    private fun matchCount(lotteryNumbers: LotteryNumbers): Int {
        return lotteryNumbers.numbers.filter { winnerLottery.lotteryNumbers.numbers.contains(it) }.count()
    }
}
