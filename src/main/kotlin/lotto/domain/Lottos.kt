package lotto.domain

data class Lottos(val lottos: List<Lotto>) {

    fun checkMatching(lotto: Lotto): List<Int> {
        return lottos.map { it.countMatchedNumbers(lotto) }
    }
}
