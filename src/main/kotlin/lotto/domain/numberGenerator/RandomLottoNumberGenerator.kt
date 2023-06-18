package lotto.domain.numberGenerator

class RandomLottoNumberGenerator : NumberGenerator {

    companion object {
        private const val MAX_LOTTO_NUMBER = 45
        private const val NUMBER_OF_LOTTO = 6
    }

    override fun generateNumbers(): List<Int> {
        return (1..MAX_LOTTO_NUMBER).shuffled().take(NUMBER_OF_LOTTO).sorted()
    }
}
