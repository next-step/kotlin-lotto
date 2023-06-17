package lotto.domain.lottery

class LotteryTicket(val lotteries: List<Lottery>) {
    fun getWinnerPrizeMap(winnerLottery: WinnerLottery) =
        lotteries.groupingBy { (winnerLottery.calculatePrize(it)) }.eachCount()

    fun isEmpty() = lotteries.isEmpty()

    fun getNumbersCount() = lotteries.size
}
