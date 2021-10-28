package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoNumberGenerator

class LottoService private constructor(
    val lottos: List<Lotto>,
) {
    companion object {
        fun from(lottoCount: Int = 1): LottoService {
            val lottos: List<Lotto> = (0 until lottoCount)
                .map { LottoNumberGenerator.generate() }
                .map { Lotto(it) }
                .toList()

            return LottoService(lottos)
        }
    }
}
