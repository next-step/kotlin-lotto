package lotto.domain.numberGenerator

import lotto.domain.LottoNumber

interface LottoNumberGenerator {
    fun generateNumbers(): List<LottoNumber>
}
