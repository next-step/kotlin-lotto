package lotto.domain

class Lottos(val lottos: List<Lotto>) {

    operator fun plus(other: Lottos): Lottos {
        val combinedLottos = this.lottos + other.lottos
        return Lottos(combinedLottos)
    }
}
