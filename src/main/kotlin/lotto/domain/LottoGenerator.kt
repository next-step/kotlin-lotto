package lotto.domain

class LottoGenerator {
    fun publish(lottoGenerateStrategy: LottoGenerateStrategy): Lotto {
        return lottoGenerateStrategy.generate()
    }
}
