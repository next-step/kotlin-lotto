package lotto.domain

class LottoGenerator(
    private val numberGenerator: NumberGenerator
) {

    fun generate(size: Int): List<Lotto> {
        return List(size) { Lotto(numberGenerator.generate()) }
    }
}
