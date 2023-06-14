package lotto

import java.math.BigDecimal

enum class Prize(
    val matchedCount: Int,
    val prizeAmount: BigDecimal,
) {
    FIRST(6, BigDecimal(2_000_000_000)),
    SECOND(5, BigDecimal(1_500_000)),
    THIRD(4, BigDecimal(50_000)),
    FOURTH(3, BigDecimal(5_000)),
}
