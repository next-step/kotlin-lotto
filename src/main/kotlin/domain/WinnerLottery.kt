package domain

class WinnerLottery(numbers: List<Int>) {
    val numbers: LotteryNumbers = LotteryNumbers(numbers)

    fun math(lotteries: Lotteries): HashMap<Int, Int> {
        val result = HashMap<Int, Int>()

        lotteries.lotteries.map {
            val count = matchCount(it.numbers)
            if (count == 3) {
                result[3] = result.getOrDefault(3, 0) + 1
            }

            if (count == 4) {
                result[4] = result.getOrDefault(4, 0) + 1
            }

            if (count == 5) {
                result[5] = result.getOrDefault(5, 0) + 1
            }

            if (count == 6) {
                result[6] = result.getOrDefault(6, 0) + 1
            }
        }

        return result
    }

    fun matchCount(lotteryNumbers: LotteryNumbers): Int {
        return lotteryNumbers.numbers.filter { this.numbers.numbers.contains(it) }.count()
    }
}
