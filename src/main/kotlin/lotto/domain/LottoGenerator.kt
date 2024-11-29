package lotto.domain

import lotto.domain.lottonumber.LottoNumbersGenerator

object LottoGenerator {
    fun generateLottos(
        count: Int,
        lottoNumbersGenerator: LottoNumbersGenerator,
    ) = List(count) { Lotto(lottoNumbersGenerator) }
}
