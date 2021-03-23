package lotto.domain

import lotto.domain.generator.LottoGenerator

class LottoMachine(
    private var lottoGenerator: LottoGenerator
) {
    fun setGenerator(lottoGenerator: LottoGenerator) {
        this.lottoGenerator = lottoGenerator
    }

    fun buy(): Lotto {
        return lottoGenerator.generate()
    }
}
