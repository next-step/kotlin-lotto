package lotto.domain

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): List<Int> {
        val range = LOTTO_START_NUMBER..LOTTO_END_NUMBER
        val shuffled = range.shuffled()
        return shuffled.subList(0, LOTTO_NUMBERS_SIZE).sorted()
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        const val LOTTO_NUMBERS_SIZE = 6
    }
}
