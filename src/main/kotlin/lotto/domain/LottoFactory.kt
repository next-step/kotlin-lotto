package lotto.domain

class LottoFactory(
    private val numberGenerator: LottoNumberGenerator,
) {
    fun create(quantity: Int): List<DefaultLotto> {
        return (1..quantity).map { DefaultLotto(numberGenerator.generate().toSet()) }
    }
}
