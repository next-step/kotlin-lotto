package lotto.domain

data class Lottos(val lottos: List<Lotto>) {

    fun count(): Int {
        return lottos.count()
    }
}
