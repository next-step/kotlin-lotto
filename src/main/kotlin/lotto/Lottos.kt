package lotto

class Lottos(val lottos: List<Lotto>) {

    fun getNumberOfLottos() = lottos.size
    fun getTotalPrice() = lottos.sumOf { it.salePrice }
    fun matchingAllLottos(winningLotto: WinningLotto) = lottos.map { winningLotto.countMatch(it) }
}
