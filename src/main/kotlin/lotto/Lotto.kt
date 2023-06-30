package lotto

class Lotto private constructor(
    val numbers: Set<Int>,
) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it in LOTTO_NUMBER_RANGE }) { "범위를 벗어난 숫자가 있습니다." }
    }

    fun countMatch(other: Lotto): Int {
        return this.numbers.count { other.numbers.contains(it) }
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        val LOTTO_NUMBER_RANGE = 1..45

        fun from(numbers: Set<Int>): Lotto {
            return Lotto(numbers.sorted().toSet())
        }
    }
}
