package com.nextstep.lotto.domain

class LottoResult(val result: Map<Rank, Int>) {
    fun calculateRatio(purchaseMoney: Long): Double {
        val totalWinningMoney = result.map { (rank, count) -> count * rank.winningMoney }.sum()

        return (totalWinningMoney / purchaseMoney).toDouble()
    }
}
