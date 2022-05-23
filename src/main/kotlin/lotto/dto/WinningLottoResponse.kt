package lotto.dto

import lotto.domain.LottoRank
import java.math.BigDecimal

data class WinningLottoResponse(
    val countByRank: Map<LottoRank, Int>,
    val profitRate: BigDecimal
) {
    companion object {
        fun of(countByRank: Map<LottoRank, Int>, profitRate: BigDecimal): WinningLottoResponse {
            val sortedCountByRank = countByRank.filterNot { it.key == LottoRank.NOTHING }
                .map { it.key to it.value }
                .reversed()
                .toMap()
            return WinningLottoResponse(sortedCountByRank, profitRate)
        }
    }
}
