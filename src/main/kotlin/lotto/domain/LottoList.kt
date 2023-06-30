package lotto.domain

import lotto.domain.lottoStrategy.LottoStrategy

class LottoList(
    lottos: List<Lotto>
) {
    private val _lottos = lottos.toMutableList()
    val lottos
        get() = _lottos

    fun size(): Int = lottos.size

    fun getResult(winningLotto: WinningLotto): LottoResult =
        lottos
            .groupBy { winningLotto.match(it) }
            .mapValues { it.value.size }
            .let { LottoResult(it) }

    operator fun plus(other: LottoList) {
        this._lottos.addAll(other._lottos)
    }

    companion object {
        fun of(lottoStrategy: LottoStrategy, lottoCount: Int): LottoList {
            return LottoList(
                List(lottoCount) {
                    lottoStrategy.makeLotto()
                }
            )
        }
    }
}
