package lotto.domain

import kotlin.math.floor

class LottoResult(private val userLottos: Lottos, winningLotto: Lotto, bonusBall: LottoNumber) {
    val ranks: Map<LottoRank, Lottos> = userLottos.groupByLottoRank(winningLotto, bonusBall)

    fun calculateProfitRate(): Double {
        val totalCost = userLottos.size * Lotto.LOTTO_PRICE
        val totalPrize = ranks.entries.sumOf { (rank, lottos) -> lottos.size * rank.prize }

        val profitRate = totalPrize.toDouble() / totalCost.toDouble()
        return floor(profitRate * 100) / 100
    }
}
