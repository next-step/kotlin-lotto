package lotto.domain

import lotto.domain.lottonumber.LottoNumbersGenerator

class Lotto(
    lottoNumbersGenerator: LottoNumbersGenerator,
) {
    val lottoNumbers: List<Int> = lottoNumbersGenerator.generateLottoNumbers()
}
