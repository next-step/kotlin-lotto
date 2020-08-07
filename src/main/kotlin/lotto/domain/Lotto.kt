package lotto.domain

class Lotto(numbers: List<String>) {
    val numbers = sortIt(changeNumber(numbers))

    init {
        checkSixNumbers(numbers)
        checkSameNumber(numbers)
    }

    private fun checkSixNumbers(numbers: List<String>) {
        if (numbers.size != LOTTO_HAS_NUMBERS) {
            throw IllegalArgumentException("6개의 번호만 가질수 있습니다.")
        }
    }

    private fun checkSameNumber(numbers: List<String>) {
        if (numbers.size != this.numbers.size) {
            throw IllegalArgumentException("같은 번호를 가질수 없습니다.")
        }
    }

    private fun changeNumber(numbers: List<String>): List<Number> = numbers.map { Number(it) }

    private fun sortIt(numbers: List<Number>): Set<Number> = numbers.sortedBy { it.number }.toSet()

    fun getCountMatch(correctNumbers: Set<Number>): Int = correctNumbers.filter { isCorrect(it) }.size

    fun isCorrect(number: Number): Boolean = numbers.contains(number)

    companion object {
        const val LOTTO_HAS_NUMBERS = 6
    }
}
