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
    ;

    companion object {
        fun calculateTotalPrizeAmount(lottos: Lottos, winningLotto: Lotto): BigDecimal {
            return values()
                .map {
                    val winningLottoCount = lottos.getWinningLottoCountByMatchCount(winningLotto, it.matchedCount)
                    val prizeAmount = it.prizeAmount.multiply(winningLottoCount.toBigDecimal())
                    prizeAmount
                }.sumOf { it }
        }

        fun getWinningLottoCountsByPrize(lottos: Lottos, winningLotto: Lotto): Map<Prize, Int> {
            return values()
                .reversed()
                .associateWith { lottos.getWinningLottoCountByMatchCount(winningLotto, it.matchedCount) }
        }
    }
}
