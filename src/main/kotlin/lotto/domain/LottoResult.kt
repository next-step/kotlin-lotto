package lotto.domain

import java.math.BigDecimal

data class LottoResult(val resultStatistics: Map<LottoResultRank, Int>, val profitRate: BigDecimal)
