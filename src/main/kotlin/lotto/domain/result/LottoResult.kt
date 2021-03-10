package lotto.domain.result

import lotto.domain.ticket.WinningBoard

class LottoResult {
    private val result = mutableMapOf<WinningBoard, Int>()

    init {
        WinningBoard.values()
            .forEach { result[it] = 0 }
    }

    fun add(winningBoard: WinningBoard) {
        result[winningBoard] = result[winningBoard]!!.plus(1)
    }

    fun get(winningBoard: WinningBoard): Int {
        return result[winningBoard]!!
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
