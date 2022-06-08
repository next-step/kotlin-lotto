package lotto.domain

class Lottos(
    private val _lottos: List<Lotto>,
) {
    val lottos: List<Lotto>
        get() = _lottos.toList()

    fun getStatistics(winningLotto: WinningLotto): LottoResult {
        return Rank.toResult().apply {
            val result = _lottos.map { winningLotto.match(it) }
            result.forEach { put(it, get(it)!! + 1) }
            remove(Rank.NONE)
        }.let { LottoResult(it) }
    }

    companion object {
        fun generateAutoLottos(lottoNumber: Int, autoLottoPublishStrategy: () -> Lotto): Lottos {
            return mutableListOf<Lotto>().apply {
                repeat(lottoNumber) { add(autoLottoPublishStrategy.invoke()) }
            }.let { Lottos(it.toList()) }
        }
    }
}
