package lotto

class LottoNumberGenerator : NumberGenerator {
    override fun generate(): List<Int> {
        return (MIN..MAX)
            .shuffled()
            .take(LOTTO_SIZE)
    }

    companion object {
        const val LOTTO_SIZE = 6
        private const val MIN = 1
        private const val MAX = 45
    }
}