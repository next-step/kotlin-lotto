package lotto.domain

class LottoGenerator(private val lottoGenerateStrategy: LottoGenerateStrategy) {
    fun publish(): Lotto {
        return lottoGenerateStrategy.generate()
    }
}
