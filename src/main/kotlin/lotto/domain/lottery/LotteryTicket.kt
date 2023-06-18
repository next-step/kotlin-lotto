package lotto.domain.lottery

data class LotteryTicket(val lotteries: List<Lottery>) {
    fun getWinnerPrizeMap(winnerLottery: WinnerLottery) =
        lotteries.groupingBy { (winnerLottery.calculatePrize(it)) }.eachCount()

    fun isEmpty() = lotteries.isEmpty()

    fun getNumbersCount() = lotteries.size

    infix fun merge(other: LotteryTicket): LotteryTicket {
        return LotteryTicket(listOf(this.lotteries, other.lotteries).flatten())
    }
}
