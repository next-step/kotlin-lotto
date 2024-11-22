package lotto.domain

class Lotto(numbers: Set<Int>) {
    val numbers: List<Int> = numbers.sorted()

    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "로또 번호는 1부터 45 사이여야 합니다." }
    }

    fun matchCount(winningNumbers: Set<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }
}
