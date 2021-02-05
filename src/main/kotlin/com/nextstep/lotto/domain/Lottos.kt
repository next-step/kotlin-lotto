package com.nextstep.lotto.domain

class Lottos(manualLottos: List<Lotto>, autoLottos: List<Lotto>) {
    val lottos: List<Lotto> = listOf(manualLottos, autoLottos).flatten()
    val numberOfManual = manualLottos.size

    fun getNumberOfAuto(): Int {
        return lottos.size.minus(numberOfManual)
    }
}
