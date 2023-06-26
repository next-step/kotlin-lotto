package lotto.domain

class Lottos(val lottos: List<Lotto>) {

    val size: Int
        get() {
            return lottos.size
        }
}
