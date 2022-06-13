package lotto.domain

class Lottos(
    val lottos: List<Lotto>,
) {
    fun getStatistics(winningLotto: WinningLotto): LottoResult {
        return Rank.toResult().apply {
            val result = lottos.map { winningLotto.match(it) }
            result.forEach { put(it, get(it)!! + 1) }
            remove(Rank.NONE)
        }.let { LottoResult(it) }
    }
}
