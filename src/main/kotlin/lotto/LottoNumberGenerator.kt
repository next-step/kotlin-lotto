package lotto

class LottoNumberGenerator {
    fun generate(num: Int): List<Int> {
        return (MIN..MAX)
            .shuffled()
            .take(num)
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
    }
}