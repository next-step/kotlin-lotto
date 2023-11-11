package lotto.domain

class Lottos(
    val lottos: List<Lotto>
) {
    fun getLottoRanks(winningLotto: WinningLotto): Map<LottoRank, Int> {
        return lottos.map { it.getRank(winningLotto) }.groupingBy { it }.eachCount()
    }

    fun getTotalCount(): Int {
        return lottos.size
    }
}
