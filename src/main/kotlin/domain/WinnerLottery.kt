package domain

class WinnerLottery(numbers: List<Int>) {
    val numbers: LotteryNumbers = LotteryNumbers(numbers)

    // 만약 10개 중 3개가 일치한다면
    fun match(lotteries: List<LotteryNumbers>): HashMap<Int, Int> {
        val result = HashMap<Int, Int>()

        lotteries.map {
            val count = matchCount(it)

            if (count == Rank.FOURTH.matchCount || count == 4 || count == 5 || count == 6) {
                addMatchCount(result, count)
            }
        }

        return result
    }

    private fun addMatchCount(result: HashMap<Int, Int>, count: Int) {
        result[count] = result.getOrDefault(count, DEFAULT_MATCH_COUNT) + ADD_COUNT_VALUE
    }

    fun matchCount(lotteryNumbers: LotteryNumbers): Int {
        return lotteryNumbers.numbers.filter { this.numbers.numbers.contains(it) }.count()
    }

    companion object {
        const val DEFAULT_MATCH_COUNT = 0
        const val ADD_COUNT_VALUE = 1
    }
}
