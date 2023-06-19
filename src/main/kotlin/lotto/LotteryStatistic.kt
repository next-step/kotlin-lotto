package lotto

object LotteryStatistic {

    fun getWinStatistic(
        lotteryTickets: List<Lottery>,
        lastWinnerNumbers: List<Int>
    ): Pair<List<LotteryResult>, Double> {
        val winResult = checkLotteryTickets(lotteryTickets, lastWinnerNumbers)

        val lotteryResults = mutableListOf<LotteryResult>()
        var sum = 0
        winResult.forEach { (count, matchCount) ->
            val prize = WinnerPrize.getPrize(count).money
            val message = "${count}개 일치 (${prize}원) - ${matchCount}개"
            lotteryResults.add(LotteryResult(prize, matchCount, message))
            sum += (prize * matchCount)
        }

        return lotteryResults.toList() to sum.toDouble()
    }

    private fun checkLotteryTickets(
        lotteryTickets: List<Lottery>,
        lastWinnerNumbers: List<Int>
    ): List<Pair<Int, Int>> =
        lotteryTickets.map { lottery ->
            lottery.numbers.intersect(
                lastWinnerNumbers.sorted().toSet()
            ).count()
        }.filter { it >= 3 }
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedBy { it.first }
}
