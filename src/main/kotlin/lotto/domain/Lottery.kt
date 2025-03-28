package lotto.domain

import lotto.domain.LottoMachine.Companion.LOTTO_PRICE
import java.math.BigDecimal

class Lottery(
    private val lottos: List<Lotto>,
    private val winningLotto: Lotto,
) {
    private val prizes: List<Prize> =
        lottos.map { lotto ->
            Prize.calculate(winningLotto.compareMatches(lotto))
        }

    val result =
        Prize.entries.associateWith {
            prizes.count { prize -> it == prize }
        }

    val returnRate: BigDecimal =
        prizes.sumOf { it.value }
            .toBigDecimal()
            .divide(lottos.size.times(LOTTO_PRICE).toBigDecimal())
}
