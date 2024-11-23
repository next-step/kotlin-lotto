package lotto.domain

class LottoFactory(
    private val numberGenerator: LottoNumberGenerator,
) {
    fun create(quantity: Int): List<Lotto> {
        return (1..quantity).map { Lotto(numberGenerator.generate()) }
    }
}
