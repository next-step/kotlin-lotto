package lotto

class LottoGenerator(private val generator: LottoNumberGenerator) {
    fun generate(): Lotto {
        return Lotto(generator.generate())
    }
}
