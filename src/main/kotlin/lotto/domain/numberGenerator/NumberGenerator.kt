package lotto.domain.numberGenerator

import lotto.domain.LottoNumber

interface NumberGenerator {
    fun generateNumbers(): List<LottoNumber>
}
