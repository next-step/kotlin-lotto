package lotto.domain.generator

import lotto.domain.Lotto

interface LottoGeneratorStrategy {
    fun generate(lottoCount: Int): List<Lotto>
}
