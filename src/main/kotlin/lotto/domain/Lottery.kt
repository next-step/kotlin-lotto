package lotto.domain

import lotto.domain.LottoMachine.Companion.LOTTO_PRICE

class Lottery(
    lottos: Lottos,
    winningLotto: Lotto,
    bonusNumber: LottoNumber,
) {
    private val prizes: List<Prize> =
        lottos
            .compareAllTo(winningLotto)
            .map { Prize.calculate(it.value, it.key.contains(bonusNumber)) }

    val result =
        Prize.entries.associateWith {
            prizes.count { prize -> it == prize }
        }

    val returnRate: Double =
        prizes.sumOf { it.value }.toDouble() / (lottos.size * LOTTO_PRICE)
}
