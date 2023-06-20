import domain.Lottery
import domain.Prize
import domain.WinningFinder

object LotteryCalculator {
    fun calculatePrizes(lotteries: List<Lottery>, winningFinder: WinningFinder): Map<Prize, Int> {
        return lotteries.mapNotNull { winningFinder.getPrizeByMatched(it) }
            .groupingBy { it }
            .eachCount()
    }
}
