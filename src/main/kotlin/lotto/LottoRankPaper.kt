package lotto

import lotto.LottoConst.Companion.lottoPay
import kotlin.math.floor

class LottoRankPaper(private val ranks: List<LottoRank>) {

    fun getRankCount(rank: LottoRank): Int {
        return ranks.filter { it == rank }.size
    }

    fun getPrizeRate(): Double {
        var totalSum = 0
        ranks.forEach {
            totalSum += it.prizeMoney * getRankCount(it)
        }
        val paymentAmount = ranks.size * lottoPay
        val result = if (totalSum <= 0) 0.0 else totalSum.toDouble().div(paymentAmount.toDouble())
        return floor(result * 100) / 100
    }
}
