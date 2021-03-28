package lotto.domain.result

import lotto.domain.ticket.WinningBoard
import lotto.domain.value.Price

class LottoResult(
    winningBoards: List<WinningBoard>
) {
    private val result = mutableMapOf<WinningBoard, Int>()

    init {
        winningBoards.forEach {
            result[it] = this.get(it) + 1
        }
    }

    fun result() = result.toMap()

    fun get(winningBoard: WinningBoard): Int {
        return result[winningBoard] ?: NOT_EXIST
    }

    fun calculateProfit(price: Price): Double {
        return Price(calculateTotalReward()).rate(price)
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

    companion object {
        private const val NOT_EXIST = 0
    }
}
