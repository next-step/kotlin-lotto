package lotto.`in`.dto

class WinningStatistic(winningPrizes: List<Pair<Int, Int>>, duplicateMatchedCount: Map<Int, Int>) {
    val winningStatistic: List<Triple<Int, Int, Int>>

    init {
        winningStatistic = winningPrizes.map { (matchedCount, prize) ->
            Triple(matchedCount, prize, duplicateMatchedCount.getOrDefault(matchedCount, 0))
        }
    }
}
