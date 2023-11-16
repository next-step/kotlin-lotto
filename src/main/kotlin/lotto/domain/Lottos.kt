package lotto.domain

class Lottos(val lottos: List<Lotto>) : List<Lotto> by lottos {

    fun merge(otherLottos: Lottos): Lottos {
        return Lottos(lottos + otherLottos.lottos)
    }

    fun match(winningLotto: Lotto, bonusBall: Int): Ranks {
        return Ranks(lottos.map { it.match(winningLotto, bonusBall) })
    }

    fun getCount(type: LottoType): Int {
        return lottos.count { it.type == type }
    }
}
