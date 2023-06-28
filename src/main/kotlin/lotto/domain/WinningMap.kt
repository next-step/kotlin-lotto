package lotto.domain

class WinningMap(
    private val winningMap: Map<LottoPrizes, Int>
) {
    fun totalPrizeMoney(): Int {
        var totalPrizeMoney = 0

        winningMap.forEach { (prize, count) ->
            totalPrizeMoney += prize.money * count
        }

        return totalPrizeMoney
    }

    fun numberOfMatch(lottoPrizes: LottoPrizes): Int {
        return winningMap.getOrDefault(lottoPrizes, 0)
    }
}
