package lotto

class LottoNumberGenerator {
    fun generate(size: Int): List<Int> {
        return (MIN..MAX)
            .shuffled()
            .take(size)
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
    }
}