package lotto.component

class LottoNumberGenerator {
    fun generate(): List<Int> {
        return NUMBER_POOL.shuffled()
            .subList(0, LOTTO_NUMBER_LENGTH)
            .sorted()
    }

    companion object {
        private val NUMBER_POOL = (1..45).toList()
        const val LOTTO_NUMBER_LENGTH = 6
    }
}
