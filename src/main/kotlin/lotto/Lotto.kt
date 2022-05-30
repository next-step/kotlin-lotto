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
}
