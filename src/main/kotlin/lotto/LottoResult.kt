package lotto

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult(
    private val lottos: List<Lotto>,
    private val winningNumber: WinningNumber
) {
    fun countByLottoMatch(): Map<LottoMatch, Int> {
        val initialMap = enumValues<LottoMatch>().associateWith { 0 }

        return initialMap + lottos.map { winningNumber.match(it) }
            .groupingBy { it }
            .eachCount()
    }

    fun profit(payment: Int): BigDecimal {
        val winning = lottos.map { Winning.of(winningNumber.match(it)) }
            .sumOf { it.money }

        return BigDecimal.valueOf(winning).divide(BigDecimal.valueOf(payment.toDouble()), 2, RoundingMode.DOWN)
    }
}
