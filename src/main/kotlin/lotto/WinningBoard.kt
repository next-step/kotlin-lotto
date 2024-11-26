package lotto

import lotto.LotteryTicketMachine.Companion.TICKET_PRICE

class WinningBoard(private val winningResults: List<WinningResult>) {
    fun getWinningCount(winningResult: WinningResult): Int = winningResults.count { it == winningResult }

    fun calculateRateOfReturn(totalCost: Money): RateOfReturn {
        require(totalCost >= TICKET_PRICE) {
            "총 구매 비용은 최소 로또 티켓 1매 가격이어야 합니다"
        }

        val totalWinningAmount = winningResults.sumOf { it.winnings }
        return RateOfReturn(totalWinningAmount = totalWinningAmount, totalCost = totalCost)
    }
}

fun <T> Iterable<T>.sumOf(selector: (T) -> Money): Money {
    return this.fold(Money.ZERO) { acc, element -> acc + selector(element) }
}
