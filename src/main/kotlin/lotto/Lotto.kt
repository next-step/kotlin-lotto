package lotto

class Lotto(private val numbers: List<Int>) {
    val sortedNumbers: List<Int>
        get() = numbers
    init {
        require(numbers.size == LOTTO_SIZE) { "로또는 6개의 숫자여야 합니다." }
        require(numbers.distinct().size == LOTTO_SIZE) { "로또 번호는 중복될 수 없습니다." }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { "로또 번호는 1부터 45 사이여야 합니다." }
    }

    fun match(other: Lotto): Int {
        return numbers.count { other.numbers.contains(it) }
    }
    companion object {

        private const val MAX_LOTTO_NUMBER = 45
        private const val MIN_LOTTO_NUMBER = 1
        private const val LOTTO_SIZE = 6

        fun randomGenerate(): Lotto {
            return Lotto((MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).shuffled().take(LOTTO_SIZE))
        }
    }


}
