package lotto

@JvmInline
value class Lotto(val numbers: Set<Int>) {
    init {
        require(numbers.size == LOTTO_COUNT)
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER })
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun countMatchedNumber(lotto: Lotto): Int {
        return lotto.numbers.filter { this.contains(it) }.size
    }

    companion object {
        private const val LOTTO_COUNT = 6
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45

        fun generator(): LottoGenerator {
            return LottoGenerator(LOTTO_COUNT, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
        }
    }
}
