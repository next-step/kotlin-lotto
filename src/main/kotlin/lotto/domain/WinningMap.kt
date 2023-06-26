package lotto.domain

class WinningMap(
    val winningMap: Map<LottoPrizes, Int>
) {
    fun totalPrizeMoney(): Int {
        var totalPrizeMoney = 0

        winningMap.forEach { (prize, count) ->
            totalPrizeMoney += prize.money * count
        }

        return totalPrizeMoney
    }
}
