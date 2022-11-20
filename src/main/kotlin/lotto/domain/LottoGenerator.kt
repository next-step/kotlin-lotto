package lotto.domain

class LottoGenerator(
    private val numberGenerator: NumberGenerator
) {
    fun generate(size: Int): List<Lotto> {
        return List(size) { Lotto(randomNumber()) }
    }

    private fun randomNumber(): List<Int> {
        return numberGenerator.random(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE)
    }

    companion object {
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_END_NUMBER = 45
        private const val LOTTO_SIZE = 6
    }
}
