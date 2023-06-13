package lotto.model

import lotto.model.LottoRank.Companion.totalPrize
import java.math.BigDecimal

data class LottoScore(
    private val ranks: Collection<LottoRank>,
    private val totalPrice: Long,
) {

    init {
        require(0 <= totalPrice) {
            "totalPrice must be zero or positive. but provided totalPrice(`$totalPrice`)"
        }
    }

    infix fun count(rank: LottoRank): Int {
        return ranks.count { it == rank }
    }

    val ratio: BigDecimal
        get() {
            return ranks.totalPrize.toBigDecimal() / totalPrice.toBigDecimal()
        }
}
