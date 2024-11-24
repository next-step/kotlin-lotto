package lotto.domain

class Lotto(numbers: Set<Int>) {
    val numbers: List<Int> = numbers.sorted()

    init {
        LottoRule.validate(numbers)
    }

    fun matchCount(winningNumbers: Set<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }

    fun intersect(other: Lotto): Set<Int> {
        return numbers.intersect(other.numbers)
    }

    operator fun contains(number: BonusNumber): Boolean {
        return number.value in numbers
    }
}
