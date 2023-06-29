package lotto.domain

import lotto.domain.lottoStrategy.LottoStrategy

data class LottoList(
    val lottos: List<Lotto>
) {
    fun size(): Int = lottos.size

    fun getResult(winningLotto: WinningLotto): LottoResult =
        lottos
            .groupBy { winningLotto.match(it) }
            .mapValues { it.value.size }
            .let { LottoResult(it) }

    companion object {
        fun of(lottoStrategy: LottoStrategy, lottoCount: Int): LottoList {
            return LottoList(
                List(lottoCount) {
                    lottoStrategy.makeLottoNumbers()
                }
            )
        }
    }
}
