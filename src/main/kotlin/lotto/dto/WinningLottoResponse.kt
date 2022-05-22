package lotto.dto

import lotto.domain.LottoRank
import java.math.BigDecimal

data class WinningLottoResponse(
    val countByRank: Map<LottoRankResponse, Int>,
    val profitRate: BigDecimal
) {
    companion object {
        fun of(countByRank: Map<LottoRank, Int>, profitRate: BigDecimal): WinningLottoResponse {
            return WinningLottoResponse(
                countByRank.filterNot { it.key == LottoRank.NOTTING }
                    .map { LottoRankResponse.of(it.key) to it.value }
                    .reversed()
                    .toMap(),
                profitRate
            )
        }
    }

    data class LottoRankResponse(
        val matchCount: Int,
        val amount: BigDecimal
    ) {
        companion object {
            fun of(lottoRank: LottoRank): LottoRankResponse {
                return LottoRankResponse(lottoRank.matchCount, lottoRank.winningAmount.amount)
            }
        }
    }
}
