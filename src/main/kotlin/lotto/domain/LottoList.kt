package lotto.domain

import lotto.domain.lottoStrategy.LottoStrategy

data class LottoList(
    val lottos: List<Lotto>
) {
    companion object {
        fun of(lottoStrategy: LottoStrategy, lottoCount: Long): LottoList {
            return LottoList(
                (1..lottoCount).map {
                    Lotto(lottoStrategy.makeLottoNumbers())
                }
            )
        }
    }
}
