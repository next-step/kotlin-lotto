package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

typealias MatchedCount = Int

class WinningStatistics(private val winningLotto: WinningLotto) {
    private lateinit var statistics: Map<Rank, MatchedCount>

    fun calculateStatistics(purchasedLottos: PurchasedLottos): WinningStatistics {
        statistics =
            purchasedLottos
                .calculateRanks(winningLotto)
        return this // 메서드 체이닝 지원
    }

    fun count(rank: Rank): Int = statistics[rank] ?: 0

    fun totalPrize(): BigDecimal {
        return statistics.map { (rank, count) ->
            rank.totalPrize(count)
        }.reduce(BigDecimal::add)
    }

    fun profitRate(lottoCount: Int): BigDecimal {
        val purchaseAmount = BigDecimal(lottoCount * LottoStore.LOTTO_PRICE)
        val totalPrize = totalPrize()
        return if (purchaseAmount > BigDecimal.ZERO) {
            totalPrize.divide(purchaseAmount, 2, RoundingMode.HALF_UP)
        } else {
            BigDecimal.ZERO
        }
    }
}
