package lotto.domain

class Lottery(private val numbers: Set<Int>) {
    init {
        validateNumberSize()
        validateEachNumberInRange()
    }

    private fun validateNumberSize() {
        require(numbers.size == LOTTERY_NUMBER_SIZE) { "로또는 6자리입니다." }
    }

    private fun validateEachNumberInRange() {
        require(numbers.all { it in LOTTERY_NUMBER_RANGE }) { "로또의 숫자는 1~45 사이의 정수가 가능합니다." }
    }

    infix fun intersectNumbers(other: Lottery): Set<Int> {
        return this.numbers.intersect(other.numbers)
    }

    companion object {
        const val LOTTERY_NUMBER_SIZE = 6
        val LOTTERY_NUMBER_RANGE = (1..45)
    }

    override fun toString(): String {
        return "${numbers.sorted()}"
    }
}
