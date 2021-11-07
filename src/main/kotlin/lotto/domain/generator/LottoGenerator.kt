package lotto.domain.generator

import lotto.domain.Lotto

class LottoGenerator {

    fun generate(lottoCount: Int, lottoGeneratorStrategy: LottoGeneratorStrategy): List<Lotto> {
        return lottoGeneratorStrategy.generateAuto(lottoCount)
    }

    fun generate(inputtedManualNumbers: List<String>, lottoGeneratorStrategy: LottoGeneratorStrategy): List<Lotto> {
        return lottoGeneratorStrategy.generateManual(inputtedManualNumbers)
    }
}
