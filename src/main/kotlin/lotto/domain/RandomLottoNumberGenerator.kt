package lotto.domain

class RandomLottoNumberGenerator: LottoNumberGenerator {

    override fun generate(): List<Int> {
        return (MIN_NUMBER..MAX_NUMBER).shuffled().take(LOTTO_NUMBER_COUNT).sorted()
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
