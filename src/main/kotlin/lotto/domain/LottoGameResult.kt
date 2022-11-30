package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

enum class LottoGameResult(val criteriaForWinning: Int, val bonusCount: Int, val prize: BigDecimal) {

    FAIL(2, 0, BigDecimal(0)),
    FIFTH(3, 0, BigDecimal(5_000)),
    FOUR(4, 0, BigDecimal(50_000)),
    THIRD(5, 0, BigDecimal(1_500_000)),
    SECOND(5, 1, BigDecimal(30_000_000)),
    FIRST(6, 0, BigDecimal(2_000_000_000));

    companion object {

        fun getResultOfWinning(number: Int, bonus: Int): LottoGameResult {
            if (number <= FAIL.criteriaForWinning) return FAIL
            return values().find { it.criteriaForWinning == number && it.bonusCount == bonus }
                ?: values().find { it.criteriaForWinning == number } ?: FAIL
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
