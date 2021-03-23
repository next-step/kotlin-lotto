package lotto.domain.generator

import lotto.domain.Lotto

interface LottoGenerator {
    fun generate(): Lotto
}
