package lotto.domain

class LottoFactory(
    private val numberGenerator: LottoNumberGenerator,
) {
    fun createAuto(quantity: Int): List<DefaultLotto> {
        return (1..quantity).map { DefaultLotto(numberGenerator.generate().toSet()) }
    }

    fun createManual(numbers: List<List<Int>>): List<DefaultLotto> {
        return numbers.map { DefaultLotto(it.map(::LottoNumber).toSet()) }
    }
}
