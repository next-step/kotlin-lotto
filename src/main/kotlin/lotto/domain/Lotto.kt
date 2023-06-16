package lotto.domain

class Lotto(
    val numbers: List<Int>
) {
    init {
        require(numbers.size == NUMBER_OF_LOTTO_NUMBERS) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it > 0 }) { "로또 번호는 양수여야 합니다." }
        require(numbers.all { it in LOTTO_NUMBERS }) { "로또 번호는 1~45 사이의 숫자여야 합니다." }
    }

    fun checkEqualCount(anotherLotto: Lotto): Int {
        val otherNumbers = anotherLotto.numbers
        return otherNumbers.intersect(numbers.toSet()).count()
    }

    companion object {
        val LOTTO_NUMBERS: List<Int> = (1..45).toList()
        const val NUMBER_OF_LOTTO_NUMBERS: Int = 6

        fun auto(): Lotto {
            val numbers = LOTTO_NUMBERS.shuffled().take(NUMBER_OF_LOTTO_NUMBERS)
            return Lotto(numbers)
        }
    }
}
