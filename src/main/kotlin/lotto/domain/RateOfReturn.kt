package lotto.domain

import lotto.constants.WinningRank

class RateOfReturn(
    private val totalPrice: Int,
    private val winningRankList: List<WinningRank>
) {
    init {
        require(totalPrice > 0) {
            "로또 구입 금액은 0보다 커야 합니다."
        }
    }

    fun calculate(): Double {
        val totalWinningMoney = winningRankList.sumOf { it.money }
        return totalWinningMoney.toDouble() / totalPrice.toDouble()
    }
}
