package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

enum class LottoGameResult(val criteriaForWinning: Int, val prize: BigDecimal) {

    FIRST(6, BigDecimal(20_00_000_000)),
    SECOND(5, BigDecimal(1_500_000)),
    THIRD(4, BigDecimal(50_000)),
    FOUR(3, BigDecimal(5_000)),
    FAIL(2, BigDecimal(0));

    companion object {

        fun getResultOfWinning(number: Int): LottoGameResult {
            if (number <= FAIL.criteriaForWinning) return FAIL
            return values().first { it.criteriaForWinning == number }
        }

        fun winningStatistics(
            gameResult: List<LottoGameResult>,
            onStatistics: (map: Map.Entry<LottoGameResult, Int>) -> Unit
        ) {
            mapOf(
                FOUR to gameResult.count { it == FOUR },
                THIRD to gameResult.count { it == THIRD },
                SECOND to gameResult.count { it == SECOND },
                FIRST to gameResult.count { it == FIRST }
            ).forEach {
                onStatistics(it)
            }
        }

        fun rate(gameResult: List<LottoGameResult>, purchasingCost: BigDecimal): BigDecimal {
            val totalPrize = gameResult.sumOf { it.prize }
            return totalPrize.divide(purchasingCost, 2, RoundingMode.CEILING).stripTrailingZeros()
        }
    }
}
