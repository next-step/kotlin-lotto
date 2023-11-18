package lotto.domain

import lotto.error.ErrorMessage.LOTTOS_EMPTY

class Lottos(val lottos: List<Lotto>) {
    init {
        require(lottos.isNotEmpty()) { LOTTOS_EMPTY.message }
    }

    operator fun plus(other: Lottos): Lottos {
        val combinedLottos = this.lottos + other.lottos
        return Lottos(combinedLottos)
    }
}
