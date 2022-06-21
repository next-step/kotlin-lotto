package lotto.domain

class Lottos(
    val lottos: List<Lotto>,
) {
    fun getStatistics(winningLotto: WinningLotto): LottoResult {
        return lottos.map { winningLotto.match(it) }
            .groupingBy { it }
            .eachCount()
            .let { LottoResult(it) }
    }
}
