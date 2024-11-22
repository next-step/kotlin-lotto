package lotto.domain

class Lotto(numbers: Set<Int>) {
    val numbers: List<Int> = numbers.sorted()

    init {
        LottoRule.validate(numbers)
    }

    fun matchCount(winningNumbers: Set<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }
}
