package lotto.domain

class Lottos(private val lottos: List<Lotto>) : List<Lotto> by lottos {

    companion object {
        fun buyRandom(price: Int): Lottos {
            return Lottos(emptyList())
        }
    }
}
