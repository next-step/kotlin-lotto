package lotto.domain.result

import lotto.domain.ticket.WinningBoard
import lotto.domain.value.Price

class LottoResult {
    val result = mutableMapOf<WinningBoard, Int>()

    fun add(winningBoard: WinningBoard) {
        result[winningBoard] = result[winningBoard]?.plus(1) ?: 1
    }

    fun get(winningBoard: WinningBoard): Int {
        return result[winningBoard] ?: 0
    }

    fun calculateProfit(price: Price): Double {
        return Price(calculateTotalReward()).calculateRate(price)
    }

    fun calculateTotalReward(): Long {
        return result.map {
            it.key.times(it.value)
        }.sum()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoResult

        if (result != other.result) return false

        return true
    }

    override fun hashCode(): Int {
        return result.hashCode()
    }
}
