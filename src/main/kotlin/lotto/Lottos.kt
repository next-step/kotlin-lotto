package lotto

class Lottos(val lottos: List<Lotto>) {

    fun getNumberOfLottos() = lottos.size

    fun getNumberOfManualLottos() = lottos.filter { it.lottoType == LottoType.MANUAL }.size

    fun getNumberOfAutoLottos() = lottos.filter { it.lottoType == LottoType.AUTO }.size

    fun getTotalPrice() = lottos.sumOf { it.salePrice }
    fun matchingAllLottos(winningLotto: WinningLotto) = lottos.map { winningLotto.countMatch(it) }
}
