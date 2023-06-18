package lotto.model

import lotto.model.LottoRank.Companion.totalPrize
import java.math.BigDecimal
import java.math.RoundingMode

data class LottoScore(
    private val ranks: Collection<LottoRank>,
    private val totalPrice: Long,
) {
    init {
        require(0 <= totalPrice) {
            "totalPrice must be zero or positive. but provided totalPrice(`$totalPrice`)"
        }
    }

    infix fun countBy(rank: LottoRank): Int {
        return ranks.count { it == rank }
    }

    val ratio: BigDecimal
        get() {
            return ranks.totalPrize.toBigDecimal()
                .divide(totalPrice.toBigDecimal(), DEFAULT_SCALE, RoundingMode.HALF_UP)
        }

    companion object {
        private const val DEFAULT_SCALE: Int = 2
    }
}
