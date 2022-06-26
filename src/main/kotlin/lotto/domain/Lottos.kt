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

    operator fun plus(otherLottos: Lottos): Lottos {
        return Lottos(lottos.plus(otherLottos.lottos))
    }
}
