package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

enum class LottoGameResult(val criteriaForWinning: Int, val prize: BigDecimal) {

    FAIL(2, BigDecimal(0)),
    FOUR(3, BigDecimal(5_000)),
    THIRD(4, BigDecimal(50_000)),
    SECOND(5, BigDecimal(1_500_000)),
    FIRST(6, BigDecimal(20_00_000_000));

    companion object {

        fun getResultOfWinning(number: Int): LottoGameResult {
            if (number <= FAIL.criteriaForWinning) return FAIL
            return values().first { it.criteriaForWinning == number }
        }

        fun winningStatistics(gameResult: List<LottoGameResult>) =
            values().associateWith {
                gameResult.count { result -> result == it }
            }.filter { it.key != FAIL }

        fun rate(gameResult: List<LottoGameResult>, purchasingCost: BigDecimal): BigDecimal {
            val totalPrize = gameResult.sumOf { it.prize }
            return totalPrize.divide(purchasingCost, 2, RoundingMode.CEILING).stripTrailingZeros()
        }
    }
}
