package lotto.domain

class Lottos(val lottos: List<Lotto>, val size: Int) {

    constructor(lottos: List<Lotto>) : this(lottos, lottos.size)

    fun merge(otherLottos: Lottos): Lottos {
        return Lottos(lottos + otherLottos.lottos)
    }

    fun match(winningLotto: Lotto, bonusBall: Int): Ranks {
        return Ranks(lottos.map { it.match(winningLotto, bonusBall) })
    }
}
