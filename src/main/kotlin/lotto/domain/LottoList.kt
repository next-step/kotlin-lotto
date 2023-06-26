package lotto.domain

import lotto.domain.lottoStrategy.LottoStrategy

data class LottoList(
    val lottos: List<Lotto>
) {

    fun getResult(previousLottoNumbers: LottoNumbers): LottoResult =
        LottoResult(
            lottos
                .groupBy { it.countMatchNumbers(previousLottoNumbers) }
                .mapValues { LottoList(it.value) }
        )

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
