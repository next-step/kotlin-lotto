package lotto.domain

class LottoGenerator(private val generator: LottoNumberGenerator) {
    fun generate(): Lotto {
        return Lotto.from(generator.generate())
    }
}
