import domain.Lottery
import domain.Prize
import domain.WinningChecker

object LotteryCalculator {
    fun calculatePrizes(lotteries: List<Lottery>, winningChecker: WinningChecker): Map<Prize, Int> {
        return lotteries.mapNotNull { winningChecker.calculatePrize(it) }
            .groupingBy { it }
            .eachCount()
    }
}
