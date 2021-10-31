package lotto.domain.generator

import lotto.domain.Lotto

class LottoGenerator {

    fun generate(lottoCount: Int, lottoGeneratorStrategy: LottoGeneratorStrategy): List<Lotto> {
        return lottoGeneratorStrategy.generate(lottoCount)
    }
}
