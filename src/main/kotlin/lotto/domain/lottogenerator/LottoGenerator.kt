package lotto.domain.lottogenerator

import lotto.domain.Lotto

interface LottoGenerator {
    fun generate(): Lotto
}
