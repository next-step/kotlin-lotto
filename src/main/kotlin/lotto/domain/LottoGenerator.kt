package lotto.domain

class LottoGenerator {
    fun publish(lottoNumbersGenerateStrategy: LottoNumbersGenerateStrategy): Lotto {
        return Lotto(lottoNumbersGenerateStrategy.generate())
    }
}
