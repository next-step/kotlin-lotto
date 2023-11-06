package lotto.domain

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBER_NUM) { "로또 번호는 6개여야 합니다." }
    }
    constructor () : this(generateLotto())

    fun matches(winningNumbers: Lotto): Int {
        return numbers.intersect(winningNumbers.toSet()).size
    }
    private fun toSet(): Set<Int> {
        return numbers.toSet()
    }

    override fun toString(): String {
        return "[${numbers.joinToString(", ")}]"
    }

    companion object {
        const val NUMBER_NUM = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        private fun generateLotto(): List<Int> {
            return (MIN_NUMBER..MAX_NUMBER)
                .shuffled()
                .take(NUMBER_NUM)
                .sorted()
        }
    }
}
