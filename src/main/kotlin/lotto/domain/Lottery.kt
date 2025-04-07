package lotto.domain

import lotto.domain.LottoMachine.Companion.LOTTO_PRICE

class Lottery(
    lottos: List<Lotto>,
    winningLotto: Lotto,
    bonusNumber: LottoNumber,
) {
    private val prizes: List<Prize> =
        lottos.map { lotto ->
            Prize.calculate(winningLotto.compareMatches(lotto), lotto.contains(bonusNumber))
        }

    val result =
        Prize.entries.associateWith {
            prizes.count { prize -> it == prize }
        }

    val returnRate: Double =
        prizes.sumOf { it.value }.toDouble() / (lottos.size * LOTTO_PRICE)
}
