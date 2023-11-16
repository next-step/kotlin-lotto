package lotto.domain

import java.math.BigDecimal

data class LottoResult(
    val earningRate: BigDecimal,
    val earnResult: Map<Int, Int>
) {
}