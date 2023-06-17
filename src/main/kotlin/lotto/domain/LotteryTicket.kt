package lotto.domain

class LotteryTicket(val lotteries: List<Lottery>) {
    fun getMatchingCountMap(winnerLottery: Lottery) =
        lotteries
            .groupingBy { (it intersect winnerLottery).size }
            .eachCount()
    fun isEmpty() = lotteries.isEmpty()

    fun getNumbersCount() = lotteries.size
}
