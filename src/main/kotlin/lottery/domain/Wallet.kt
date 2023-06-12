package lottery.domain

class Wallet(
    val usedMoney: Int,
    val purchasedLotteries: Lotteries
) {
    fun calculateLotteryResult(winLottery: Lottery): Map<Rank, Int> {
        return purchasedLotteries.compareWinningLottery(winLottery)
    }
}
