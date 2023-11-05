package lotto.domain

class LottoGenerator(private val lottoGenerateStrategy: LottoGenerateStrategy) {
    fun publish(): Lotto {
        val numbers = lottoGenerateStrategy.generate()

        return Lotto(numbers)
    }
}
